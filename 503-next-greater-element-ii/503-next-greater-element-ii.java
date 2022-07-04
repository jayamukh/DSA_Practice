class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st  = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 2*nums.length -1; i >= 0 ; i--)
        {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i % nums.length])
            {
                st.pop();
            }
            res[i % nums.length] = st.empty() ? -1 : nums[st.peek()];
            st.push(i % nums.length);
            
        }
        return res;
    }
}