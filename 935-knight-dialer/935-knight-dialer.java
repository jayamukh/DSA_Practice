class Solution {
   /* public final int max = (int) Math.pow(10, 9) + 7;
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
            return memo[n][i][j] = 1;
        
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
    } */
    
    public int knightDialer(int N) {
        if(N==1) return 10;
        long mod = 1000000007;
        long[][] matrix = {
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},                     
            {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},            
        };        
        long[][] resultMatrix = new long[10][10];
        boolean resultNotEmpty = false;
        long res = 0;
        N=N-1;
        while(N>0){
            if(N%2==1){
                if(resultNotEmpty){
                    resultMatrix = matrixMultiply(resultMatrix, matrix);       
                } else {
                    resultNotEmpty = true;
                    resultMatrix = matrix;                                   
                }                 
            }
            matrix = matrixMultiply(matrix, matrix);
            N/=2;
        }
        long sum = 0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                sum = (sum+resultMatrix[i][j])%mod;
            }
        }
        return (int)sum;
        
    }
    private long[][] matrixMultiply(long[][] matrix1, long[][]matrix2){
        long mod = 1000000007;
        long[][] resultMatrix = new long[10][10];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<10; k++){
                    resultMatrix[i][j] =  (resultMatrix[i][j]+matrix1[i][k]*matrix2[k][j])%mod;
                }
                
            }
        }  
        return resultMatrix;
    }
}