/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WQFWithFind {
    private int[] parent;
    private int[] sz;
    private int[] max;
    private int count;

    public WQFWithFind(int n) {
        count = n;
        parent = new int[n];
        sz = new int[n];
        max = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            max[i] = i;
        }

        for (int i = 0; i < n; i++) {
            sz[i] = 1;
        }
    }

    public int Count() {
        return count;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public int FindRoot(int p) {
        validate(p);
        while (parent[p] != p)
            p = parent[p];
        return p;
    }

    public int Find(int r) {
        return max[FindRoot(r)];
    }

    public boolean Connected(int p, int q) {
        return FindRoot(p) == FindRoot(q);
    }

    public void Union(int p, int q) {
        int i = FindRoot(p);
        int j = FindRoot(q);

        if (i == j) return;

        if (sz[i] < sz[j]) {
            parent[i] = j;
            sz[j] += sz[i];
            max[j] = (max[i] > max[j]) ? max[i] : max[j];
        }
        else {
            parent[j] = i;
            sz[i] += sz[j];
            max[i] = (max[i] > max[j]) ? max[i] : max[j];
        }
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WQFWithFind uf = new WQFWithFind(n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.Connected(p, q)) continue;
            uf.Union(p, q);
            // StdOut.println(p + " " + q);
        }
        StdOut.println(uf.Count() + " components");

        StdOut.println("Max number in component containing 2 is: " + uf.Find(2));
    }

}
