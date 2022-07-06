class Solution {
    public int getMaxLen(int[] nums) {
       
        int posLen = 0;
        int negLen = 0;
        int ans  = 0;
        for(int num:nums)
        {
            if(num == 0)
            {
                posLen = 0;
                negLen = 0;
            }
            else if(num > 0)
            {
                posLen++;
                if(negLen > 0)
                {
                    negLen++;
                }
            }
            else
            {
                int temp  = posLen;
                posLen = negLen == 0 ? 0  : negLen+1;
                
                negLen = temp+1;
            }
            
            ans = Math.max(ans, posLen);
        }
        
        return ans;
        
    }
}