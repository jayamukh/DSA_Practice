/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  *****
 *  Last modified:     May 18, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int trialCount = 0;
    private int gridSize = 0;
    private double[] threshold;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "grid length " + n + " should be greater than 0 ");
        }
        if (trials <= 0) {
            throw new IllegalArgumentException(
                    "No. of trials " + trials + " should be greater than 0 ");
        }

        this.trialCount = trials;
        this.gridSize = n;
        threshold = new double[trialCount];
        for (int t = 0; t < trialCount; t++) {
            Percolation p = new Percolation(gridSize);
            while (!p.percolates()) {
                int rowNum = StdRandom.uniform(1, (gridSize + 1));
                int colNum = StdRandom.uniform(1, (gridSize + 1));
                p.open(rowNum, colNum);
            }
            threshold[t] = (double) p.numberOfOpenSites() / (gridSize * gridSize);
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(threshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {

        return StdStats.stddev(threshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(trialCount));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(trialCount));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = 20, trials = 10;
        if (args.length >= 2) {
            n = Integer.parseInt(args[0]);
            trials = Integer.parseInt(args[1]);
        }
        PercolationStats ps = new PercolationStats(n, trials);

        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        String interval = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("95% confidence interval = [" + interval + "]");

    }

}
