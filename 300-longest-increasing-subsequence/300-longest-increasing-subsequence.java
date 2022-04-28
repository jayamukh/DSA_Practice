class Solution {
    
     public int BS(ArrayList<Integer> dp, int ele){
        int si=0;
        int ei=dp.size()-1;
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(dp.get(mid)<ele){
                si=mid+1;
            } else {
                ei=mid-1;
            }
        }
        
        return si;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        
        ArrayList<Integer> dp=new ArrayList<>();
        
        for(int i=0; i<n; i++){
            int ele=nums[i];
            
            int pos=BS(dp,ele);
            
            if(pos==dp.size()){
                dp.add(ele);
            } else {
                dp.set(pos,ele);
            }
        }
        
        return dp.size();
    }
    
    
     /*public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        
        int[] dp=new int[n];
        
        int lis=0;
        
        for(int i=0; i<n; i++){
            dp[i]=1;
            
            for(int j=i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            
            lis=Math.max(lis,dp[i]);
        }
        
//         for(int i=0; i<n; i++){
//             lis=Math.max(lis,dp[i]);
//         }
        
        return lis;
    }*/
}