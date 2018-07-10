/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    TreeNode nextnode;
    Stack<TreeNode> parents = new Stack<TreeNode>();
    
    public void addparents(TreeNode root) {
        while(root != null) {
            parents.add(root);
            root = root.left;
        }
    }
    
    public BSTIterator(TreeNode root) {
        addparents(root);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !parents.isEmpty();
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = parents.pop();
        addparents(node.right);
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
