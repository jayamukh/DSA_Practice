class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set  = new HashSet<>(wordDict);
        
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        int ret  = wordBreakTab(s, set);
        if(ret == 0)
            return false;
        else 
            return true;
    }
    
    public boolean wordBreakRec(String s, HashSet<String> set, int si) {
        //base case
        if(si == s.length())
            return true;
        for(int ei = si+1; ei <= s.length(); ei++)
        {
            if(set.contains(s.substring(si,ei)) && wordBreakRec(s, set, ei))
                return true;
        }
        
        return false;
    }
    
    //memo
    
    public int wordBreakMemo(String s, HashSet<String> set, int si, int[] memo) {
        //base case
        if(si == s.length())
        {
            return memo[si] = 1;
        }
        
        if(memo[si]!= -1)
        {
            return memo[si];
        }
        
        for(int ei = si+1; ei <= s.length(); ei++)
        {
            if(set.contains(s.substring(si,ei)) && (wordBreakMemo(s, set, ei, memo)) == 1)
                return memo[si] = 1;
        }
        
        return memo[si] = 0;
    }
    
    public int wordBreakTab(String s, HashSet<String> set) {
       int[] dp = new int[s.length() +1];
        dp[0] = 1;
        for(int i = 1; i <= s.length(); i++)
        {
        
               
        for(int ei = 0; ei < i ; ei++)
        {
            if(set.contains(s.substring(ei,i)) && dp[ei] == 1)
            {
                dp[i] = 1;
            break;
            }
        }
        }
        return dp[s.length()];
    
    }
}