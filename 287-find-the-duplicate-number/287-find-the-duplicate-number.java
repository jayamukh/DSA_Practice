class Solution {
    public int findDuplicate(int[] nums) {
        
        boolean flag[]  = new boolean[nums.length -1];
        
        for(int i =0; i < nums.length; i++ )
        {
            if(!flag[nums[i] -1])
                flag[nums[i] -1] = true;
            else
                return nums[i];
            
        }
        
        return -1;
    }
}