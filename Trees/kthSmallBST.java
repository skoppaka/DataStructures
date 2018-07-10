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
    public int kthSmallest(TreeNode root, int k) {
        //return krecur(root, k);
        return kiter(root, k);
    }
    
    public int kiter(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        
    }
    
    public int krecur(TreeNode root, int k) {
        List<Integer> ksmall = new ArrayList<Integer>();
        helper(root, k, ksmall);
        return ksmall.get(ksmall.size() -1);
    }
    
    public void helper(TreeNode root, int k, List<Integer> ksmall) {
        if(root != null && ksmall.size() < k) {
            helper(root.left, k, ksmall);
            
            if(ksmall.size() < k) {
                ksmall.add(root.val);
                helper(root.right, k, ksmall);
            }
        }
    }
    
}
