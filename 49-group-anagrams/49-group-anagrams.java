class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int[] count  = new int[26];
        
        for(String s: strs)
        {
            /*char[] ch  = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s); */
            
            Arrays.fill(count, 0);
            for(char c: s.toCharArray()) count[c - 'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++)
            {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s); 
        }
        
        return new ArrayList<>(map.values());
    }
}