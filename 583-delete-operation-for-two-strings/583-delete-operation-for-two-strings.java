class Solution {
    
    public int tab2(String text1, String text2, int n, int m){
        int[][] dp=new int[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                } else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        
        return dp[n][m];
    }
    
    
    public int minDistance(String word1, String word2) {
        
        int n=word1.length();
        int m=word2.length();
        
        int lcs = tab2(word1, word2,n, m);
        
       return ((n-lcs) + (m-lcs));
    }
}