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
    
    private boolean isLeaf(TreeNode node)
    {
        return node.left == null && node.right == null;
    }
    
    public void addLeaves(List<Integer> list, TreeNode node)
    {
        if(isLeaf(node))
        {
            list.add(node.val);
        }
        else
        {
            if(node.left != null)
            {
                addLeaves(list, node.left);
            }
            
            if(node.right != null)
            {
                 addLeaves(list, node.right);
            }
        }
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(root == null)
        {
            return list;
        }
        
        if(!isLeaf(root))
        {
            list.add(root.val);
        }
        TreeNode left  = root.left;
        while(left != null)
        {
             if(!isLeaf(left))
        {
            list.add(left.val);
        }
            if(left.left != null)
            {
                left  = left.left;
            }
            else
            {
                left  = left.right;
            }
            
        }
        
        addLeaves(list, root);
        
        Stack<Integer> s = new Stack<>();
        
        TreeNode right  = root.right;
        while(right != null)
        {
             if(!isLeaf(right))
        {
            s.push(right.val);
        }
            if(right.right != null)
            {
                right  = right.right;
            }
            else
            {
                right  = right.left;
            }
            
        }
       
        while (s.size() > 0)
        {
            list.add(s.pop());
        }
        return list;
    }
}