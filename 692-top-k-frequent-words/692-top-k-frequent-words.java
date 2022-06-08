class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word: words)
        {
            map.put(word, map.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a,b)->
            a.getValue() == b.getValue()?b.getKey().compareTo(a.getKey()): a.getValue() - b.getValue() );
        
        for(Map.Entry<String,Integer> entry: map.entrySet())
        {
            queue.offer(entry);
            if(queue.size() > k)
            {
                queue.poll();
            }
        }
        
        while(!queue.isEmpty())
        {
            res.add(0, queue.poll().getKey());
        }
        return res;
    }
}