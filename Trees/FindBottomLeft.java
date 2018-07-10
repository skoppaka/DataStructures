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
    
    int val = 0;
    int maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        //return find_bfs(root);
        return find_dfs(root);
    }
    
    public int find_dfs(TreeNode root) {
        dfs(root, 1);
        return val;
    }
    
    public void dfs(TreeNode root, int depth) {
        if(root == null)
            return;
        
        if(depth > maxDepth) {
            val = root.val;
            maxDepth = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
    
    public int find_bfs(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        TreeNode node = null;
        while(!que.isEmpty()) {
            node = que.poll();
            if(node.right != null)
                que.add(node.right);
            if(node.left != null)
                que.add(node.left);
        }
        
        return node.val;
    }
}
