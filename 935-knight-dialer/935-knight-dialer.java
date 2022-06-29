class Solution {
    public final int max = (int) Math.pow(10, 9) + 7;
    public int knightDialer(int n) {
        
        long s = 0;
        long[][][] memo = new long[n+1][4][3];
       
        for(int i = 0; i<=3; i++)
        {
            for(int j = 0; j<=2; j++)
            {
               s = (s + paths(memo,i,j,n)) % max;
            }
        }
        
        return (int) s;
    }
    
    public long paths(long[][][] memo, int i, int j, int n)
    {
        if(i<0 || j<0 || i >= 4||j >= 3 || (i>=3 && j!=1))
            return 0;
        if(n==1)
            return 1;
        
        if(memo[n][i][j] > 0)   return memo[n][i][j] ;
        
        memo[n][i][j] = paths(memo,i-2,j-1,n-1) % max +
            paths(memo,i-2,j+1,n-1) % max  +
            paths(memo,i-1,j+2,n-1) % max  +
            paths(memo,i+1,j+2,n-1) % max +
            paths(memo,i+2,j-1,n-1) % max +
            paths(memo,i+2,j+1,n-1) % max +
            paths(memo,i+1,j-2,n-1) % max +
            paths(memo,i-1,j-2,n-1) % max ;
        return memo[n][i][j];
    }
}