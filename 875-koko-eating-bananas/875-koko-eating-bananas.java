class Solution {
    /*public int minEatingSpeed(int[] piles, int h) {
        
        int left  = 1, right = 1;
        for(int pile: piles)
        {
            right = Math.max(right, pile);
        }
        
        while (left < right)
        {
             int middle = (left + right) / 2;
            int hourSpent = 0;

            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }*/
     public boolean check(int[] piles, int mid, int h){
        int total=0;
        
        for(int p:piles){
            int time=p/mid;
            
            if(p%mid!=0) time++;
            
            total+=time;
            if(total>h) return false;
        }
        
        return total<=h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int si=1;
        int ei=0;
        
        for(int e:piles) ei=Math.max(ei,e);
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(check(piles,mid,h)){
                ei=mid-1;
            } else {
                si=mid+1;
            }
        }
        
        return si;
    }
}