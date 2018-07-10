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
    public boolean isSymmetric(TreeNode root) {
        //return isSymmRecur(root, root);
        return isSymmIter(root);
    }
    
    public boolean isSymmRecur(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        else if(left == null || right == null)
            return false;
        else {
            return (left.val == right.val &&
                    isSymmRecur(left.left, right.right) &&
                    isSymmRecur(left.right, right.left));
        }
    }
    
    public boolean isSymmIter(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        que.add(root);
        
        while(!que.isEmpty()) {
            TreeNode left = que.poll();
            TreeNode right = que.poll();
            
            if(left == null && right == null)
                continue;
            else if(left == null || right == null)
                return false;
            else if(left.val != right.val)
                return false;
            
            que.add(left.left);
            que.add(right.right);
            que.add(left.right);
            que.add(right.left);
        }
        
        return true;
    }
}
