/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  #####
 *  Last modified:    May 17, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RemoveFromQF {

    private int[] parent;
    private int[] sz;
    private int count;

    public RemoveFromQF(int n) {
        count = n;
        parent = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
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
            throw new IllegalArgumentException(
                    "index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public int Find(int p) {
        validate(p);
        while (parent[p] != p)
            p = parent[p];
        return p;
    }

    public boolean Connected(int p, int q) {
        return Find(p) == Find(q);
    }

    public void Union(int p, int q) {
        int i = Find(p);
        int j = Find(q);

        if (i == j) return;

        if (sz[i] < sz[j]) {
            parent[i] = j;
            sz[j] += sz[i];
        }
        else {
            parent[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUF uf = new WeightedQuickUF(n);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.Connected(p, q)) continue;
            uf.Union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.Count() + " components");
    }

}
