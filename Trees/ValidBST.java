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
    public boolean isValidBST(TreeNode root) {
        //return isValidBSTRecur(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return isValidBSTIter(root);
    }
    
    public boolean isValidBSTRecur(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        else if(root.val <= min || root.val >= max)
            return false;
        else {
            return (isValidBSTRecur(root.left, min, root.val) &&
                    (isValidBSTRecur(root.right, root.val, max)));
        }
    }
    
    public boolean isValidBSTIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode prev = null;
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                curr = stack.pop();
                if(prev != null && prev.val >= curr.val)
                    return false;
                
                prev = curr;
                curr = curr.right;
            }
        }
        return true;
    }
}
