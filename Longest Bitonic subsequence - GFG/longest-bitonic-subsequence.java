// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        
        int dps[] = new int[n];
        int dpe[] = new int[n];
        
        for(int i = 0; i<n;i++)
        {
            dps[i]  = 1;
            for(int j = i-1; j >= 0; j--)
            {
                if(nums[i] > nums[j])
                {
                    dps[i] = Math.max(dps[i], dps[j] + 1);
                }
            }
        }
        
        for(int i = n-1; i >= 0;i--)
        {
            dpe[i]  = 1;
            for(int j = i+1; j < n; j++)
            {
                if(nums[i] > nums[j])
                {
                    dpe[i] = Math.max(dpe[i], dpe[j] + 1);
                }
            }
        }
        
        int lbs = 0;
        
        for(int i=0; i<n; i++)
        {
            lbs = Math.max(lbs, dps[i]+dpe[i]-1);   
        }
        return lbs;
    }
    
     

}