class Solution {
    
   
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] ans  = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
         PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((m1, m2)->(m1.getValue() - m2.getValue()));
        
        map.entrySet().forEach(e->{
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }            
        });
        
       return pq.stream().map(o -> o.getKey()).collect(Collectors.toList()).stream().mapToInt(i->i).toArray();
    }
}