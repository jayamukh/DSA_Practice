class KthLargest {

    private static int idx = 0;
    private static PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        
        this.idx = k;
        pq = new PriorityQueue<>();
        int n  = nums.length;      
        for(int i = 0; i < n; i++)
        {
            pq.add(nums[i]);
        }
        while(pq.size() > k)
               pq.remove();
    }
    
    public int add(int val) {
         pq.add(val);
            while(pq.size() > this.idx)
               pq.remove();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */