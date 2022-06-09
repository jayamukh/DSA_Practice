/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String recurSerial(TreeNode root, String str)
    {
        if (root ==  null)
        {
            str += "null,";
        }
        else
        {
            str += String.valueOf(root.val) + ",";
            str = recurSerial(root.left, str);
            str = recurSerial(root.right, str);
        }
        
        return str;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recurSerial(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_arr = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_arr));
        return recurDeserial(data_list);
    }
    
    public TreeNode recurDeserial(List<String> l)
    {
        if(l.get(0).equals("null"))
        {
            l.remove(0);
            return null;
        }
        TreeNode root  = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = recurDeserial(l);
        root.right = recurDeserial(l);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));