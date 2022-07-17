class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int right  = 1;
        
        int[] ans  = new int[nums.length];
        
        ans[0] = 1;
        
        for(int idx = 1; idx < nums.length; idx++)
        {
               ans[idx] = ans[idx -1] * nums[idx -1];
        }
        
        
        int suffix = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0 ; i--)
        {          
            ans[i] = suffix * ans[i];
            suffix = suffix * nums[i];
        }
        
        return ans;
        
    }
}