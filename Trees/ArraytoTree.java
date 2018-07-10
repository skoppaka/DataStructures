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
    public TreeNode sortedArrayToBST(int[] nums) {
        return ArraytoBST(nums, 0, nums.length -1);
    }
    
    public TreeNode ArraytoBST(int[] nums, int start, int end) {
        if(start > end)
            return null;
        
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = ArraytoBST(nums, start, mid -1);
        node.right = ArraytoBST(nums, mid +1, end);
        
        return node;
    }
    
}
