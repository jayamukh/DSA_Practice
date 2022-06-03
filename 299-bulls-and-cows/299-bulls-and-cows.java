class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> h = new HashMap();
        /*for(char c: secret.toCharArray())
        {
            h.put(c, h.getOrDefault(c,0)+1);
        }
        
        int bulls = 0, cows = 0;
        int n  = guess.length();
        
        for(int i = 0; i < n; i++)
        {
            char ch = guess.charAt(i);
            if(h.containsKey(ch))
            {
                if(ch == secret.charAt(i))
                {
                    bulls++;
                    
                    if(h.get(ch)<=0)
                        cows--;
                    
                }
                else
                {
                    if(h.get(ch) > 0)
                        cows++;
                }
                h.put(ch, h.get(ch) -1);
            }
        }*/
        
        int bulls = 0, cows = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < secret.length(); i++)
        {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if(s == g)
            {
                bulls++;                
            }
            else
            {
                if(map.getOrDefault(s,0) < 0)
                    cows++;
                if(map.getOrDefault(g,0) > 0)
                    cows++;
                
                map.put(s, map.getOrDefault(s,0) +1);
                map.put(g, map.getOrDefault(g,0) -1);
            }
        }
        
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}