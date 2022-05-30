class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set  = new HashSet<>(wordDict);
        
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        int ret  = wordBreakMemo(s, set, 0, memo);
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
}