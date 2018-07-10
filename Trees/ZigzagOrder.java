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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> odd = new Stack<TreeNode>();
        Stack<TreeNode> even = new Stack<TreeNode>();
        int level = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root != null)
            odd.push(root);
        
        while(!odd.isEmpty() || !even.isEmpty()) {
            List<Integer> cur_level = new ArrayList<Integer>();
            if(level %2 != 0) {
                while(!odd.isEmpty()) {
                    root = odd.pop();
                    cur_level.add(root.val);
                    if(root.left != null)
                        even.push(root.left);
                    if(root.right != null)
                        even.push(root.right);
                }
            }else {
                while(!even.isEmpty()) {
                    root = even.pop();
                    cur_level.add(root.val);
                    if(root.right != null)
                        odd.push(root.right);
                    if(root.left != null)
                        odd.push(root.left);
                }
            }
            result.add(cur_level);
            level++;
        }
        
        return result;
    }
}
