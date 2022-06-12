/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // ArrayList<Integer> nums = RecInorder(root, new ArrayList<Integer>());
        // return nums.get(k-1);
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(true)
        {
            while(root != null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(--k == 0) return root.val;
            root = root.right;
            
        }
    }
    
    
    
    public ArrayList<Integer> RecInorder(TreeNode root, ArrayList<Integer> arr)
    {
        if(root == null) return arr;
        
        RecInorder(root.left, arr);
        arr.add(root.val);
        RecInorder(root.right, arr);
        
        return arr;        
    }
}