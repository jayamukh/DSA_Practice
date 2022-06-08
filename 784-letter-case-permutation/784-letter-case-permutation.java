class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, s.toCharArray(), 0);
        return ans;        
    }
    
    public void backtrack(List<String> ans, char[] s, int idx) 
    {
        if(idx == s.length)
        {
            ans.add(new String(s));
            return;
            
        }
        
        if(Character.isLetter(s[idx]))
           {
               s[idx] = Character.toLowerCase(s[idx]);
               backtrack(ans, s, idx+1);
               s[idx] = Character.toUpperCase(s[idx]);
               backtrack(ans, s, idx+1);
               
           }
           else
           {
               backtrack(ans, s, idx+1);
           }
    }
}