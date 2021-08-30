/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  123456
 *  Last modified:     October 07, 2021
 **************************************************************************** */


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SocialNw {
    private WeightedQuickUF uf;
    private int numComponents;

    public SocialNw(int N) {
        uf = new WeightedQuickUF(N);
        numComponents = N;
    }

    public void addFriendship(int p1, int p2) {
        if (uf.Find(p1) != uf.Find(p2)) {
            --numComponents;
        }
        uf.Union(p1, p2);
    }

    public int getComponents() {
        return this.numComponents;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        SocialNw sw = new SocialNw(n);
        while (!StdIn.isEmpty()) {
            String str = StdIn.readLine();
            if (str != null && !str.trim().equals("")) {
                String[] lineArray = str.split(" ");
                int p = Integer.parseInt(lineArray[0]);
                int q = Integer.parseInt(lineArray[1]);
                String date = lineArray[2];
                String time = lineArray[3];

                sw.addFriendship(p, q);
                StdOut.println("[" + p + "," + q + "]");
                if (sw.getComponents() == 1) {
                    StdOut.println("All members were connected at: " + date + " " + time);
                    break;
                }
            }
        }
    }
}
