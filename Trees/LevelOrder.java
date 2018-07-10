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
    
    int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    void getSubList(TreeNode root, int level, List<Integer> sublist) {
        if(root == null)
            return;
        if(level == 1)
            sublist.add(root.val);
        getSubList(root.left, level-1, sublist);
        getSubList(root.right, level-1, sublist);
    }
    
    List<Integer> getLevelOrder(TreeNode root, int level) {
        List<Integer> sublist = new LinkedList<Integer>();
        
        getSubList(root, level, sublist);
        
        return sublist;
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int ht = maxDepth(root);
        
        for(int i = ht; i > 0; i--) {
            result.add(ht-i, getLevelOrder(root, i));
        }
        
        return result;
    }
}
