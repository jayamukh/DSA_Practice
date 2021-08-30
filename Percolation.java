/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  *****
 *  Last modified:     May 18, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] openSites;
    private WeightedQuickUnionUF uf, ufFull;
    private int total;
    private int openSiteCount = 0;
    private int topVM;
    private int downVM;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "index " + n + " should be greater than 0 ");
        }

        this.total = n;
        uf = new WeightedQuickUnionUF(n * n + 2);
        ufFull = new WeightedQuickUnionUF(n * n + 1);
        openSites = new boolean[n * n];
/*
        for (int index = 0; index < (n * n); index++) {
            openSites[index] = false;
        }*/
        topVM = total * total;
        downVM = total * total + 1;
    }

    // validate that p is a valid index
    private void validate(int i, int j) {
        if (i <= 0 || i > total) {
            throw new IllegalArgumentException(
                    "row index " + i + " is not between 1 and " + total);
        }
        if (j <= 0 || j > total) {
            throw new IllegalArgumentException(
                    "column index " + j + " is not between 0 and " + total);
        }
    }

    // convert 2D index to 1D index
    private int convertTo1D(int i, int j) {
        return ((i - 1) * total + (j - 1));
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        int index = convertTo1D(row, col);

        if (openSites[index]) {
            return;
        }

        openSites[index] = true;
        openSiteCount++;
        // check if neighbours are open or not, if open connect them.

        //for top row
        if (row == 1) {
            uf.union(topVM, index);
            ufFull.union(topVM, index);
        }

        //for bottom row
        if (row == total) {
            uf.union(downVM, index);
        }

        // up
        if ((row - 1) >= 1) {
            if (isOpen(row - 1, col)) {
                uf.union(index, convertTo1D(row - 1, col));
                ufFull.union(index, convertTo1D(row - 1, col));
            }
        }

        // down
        if ((row + 1) <= total) {
            if (isOpen(row + 1, col)) {
                uf.union(index, convertTo1D(row + 1, col));
                ufFull.union(index, convertTo1D(row + 1, col));
            }
        }

        // left
        if ((col - 1) >= 1) {
            if (isOpen(row, col - 1)) {
                uf.union(index, convertTo1D(row, col - 1));
                ufFull.union(index, convertTo1D(row, col - 1));
            }
        }

        // right
        if ((col + 1) <= total) {
            if (isOpen(row, col + 1)) {
                uf.union(index, convertTo1D(row, col + 1));
                ufFull.union(index, convertTo1D(row, col + 1));
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return openSites[convertTo1D(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        return (ufFull.find(convertTo1D(row, col)) == ufFull.find(topVM));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSiteCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return (uf.find(topVM) == uf.find(downVM));
    }

    // test client (optional)
    public static void main(String[] args) {
        //int n = StdIn.readInt();
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(1, 2);
        StdOut.println("Does the system percolates ? " + p.percolates());


    }
}
