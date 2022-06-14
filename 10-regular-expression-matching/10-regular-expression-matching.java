class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[p.length() +1][s.length() +1];
        
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[0].length; j++)
            {
                if(i == 0 && j == 0)
                {
                    dp[i][j] = true;
                }
                else if(i == 0)
                {
                 dp[i][j] = false;  
                }
                else if(j == 0)
                {
                    char pChar = p.charAt(i-1);
                    if(pChar == '*')
                    {
                        dp[i][j] = dp[i-2][j];
                    }
                    else
                    {
                        dp[i][j] = false;
                    }
                }
                else
                {
                    char pChar = p.charAt(i-1);
                    char sChar = s.charAt(j-1);
                    
                    if(pChar == '*')
                    {
                        dp[i][j] = dp[i-2][j];
                        char pslc = p.charAt(i-2);
                        if(pslc == '.' || pslc == sChar)
                        {
                            dp[i][j]  = dp[i][j] || dp[i][j-1];
                        }
                    }
                    else if(pChar == '.')
                    {
                         dp[i][j]  = dp[i-1][j-1];
                    }
                    else if(pChar == sChar)
                    {
                         dp[i][j]  = dp[i-1][j-1];
                    }
                    else
                    {
                         dp[i][j]  = false;
                    }
                }
            }
        }
        
        return dp[p.length()][s.length()];
    }
}