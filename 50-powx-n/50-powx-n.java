class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0)
        {
            return 1.0;
        }
        else
        {
        double half_res = myPow(x, n/2);
        if( n%2 == 0)
        {
        return half_res * half_res;
        }
            else
            {
                if (n > 0){
                return half_res*half_res*x;
            } else {
                return half_res*half_res/x;
            }
            }
    }
}
}