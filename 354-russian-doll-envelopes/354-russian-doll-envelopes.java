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
    
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        
        Arrays.sort(envelopes,(int[] a, int [] b)->{
           if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0]; // width  
        });
        
        ArrayList<Integer> dp=new ArrayList<>();
        
        
        for(int i=0; i<n; i++){
            int nwidth=envelopes[i][0];
            int nheight=envelopes[i][1];
            
            int pos=BS(dp,nheight);
            
            if(pos==dp.size()){
                dp.add(nheight);
            } else {
                dp.set(pos,nheight);
            }
        }
        
        return dp.size();
    }
    
}