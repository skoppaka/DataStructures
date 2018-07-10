/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //return recursive(root);
        return iterative(root);
    }
    
    public List<Integer> recursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        recur_helper(root, result);
        
        return result;
    }
    
    void recur_helper(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        recur_helper(root.left, result);
        result.add(root.val);
        recur_helper(root.right, result);
    }
    
    public List<Integer> iterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        
        return result;
    }
}
