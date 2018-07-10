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
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> s = new LinkedList<TreeNode>();
        s.add(root);
        StringBuilder str = new StringBuilder();
        
        while(!s.isEmpty()) {
            TreeNode tmp = s.remove();
            if(tmp == null) {
                str.append("null");
            }
            else {
                str.append(tmp.val);
                s.add(tmp.left);
                s.add(tmp.right);
            }
            str.append(",");
        }
        System.out.println(str.toString());
        return str.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> s = new LinkedList<TreeNode>();
        TreeNode root = null;
        String[] parts = data.split(",");
        
        
        for(int i = 0; i < parts.length; i++) {
            if(root == null) {
                if(parts[i].equals("null"))
                    return null;
                else {
                    root = new TreeNode(Integer.parseInt(parts[i]));
                    s.add(root);
                }
            }
            else {
                TreeNode tmp = s.remove();
                TreeNode left = null;
                TreeNode right = null;
                if(!parts[i].equals("null")) {
                    left = new TreeNode(Integer.parseInt(parts[i]));
                    s.add(left);
                }
                if(!parts[i+1].equals("null")) {
                    right = new TreeNode(Integer.parseInt(parts[i+1]));
                    s.add(right);
                }
                tmp.left = left;
                tmp.right = right;
                i++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
