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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        
        List<Integer> result = new ArrayList<Integer>();
        if(root != null)
            curr.add(root);
        int size = curr.size();
        
        while(size > 0) {
            int row_max = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++) {
                TreeNode node = curr.poll();
                if(node.val > row_max)
                    row_max = node.val;
                if(node.left != null)
                    curr.add(node.left);
                if(node.right != null)
                    curr.add(node.right);
            }
            size = curr.size();
            result.add(row_max);
        }
        
        return result;
    }
}
