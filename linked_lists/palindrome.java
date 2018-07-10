/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        //return isPalindromeIter(head);
        return isPalindromeRec(head);
    }
    
    public boolean isPalindromeRec(ListNode head) {
        left = head;
        return isPalinWrapper(head);
    }
    
    public boolean isPalinWrapper(ListNode right) {
        if(right == null)
            return true;
        
        boolean check = isPalinWrapper(right.next);
        if(!check)
            return false;
        
        check = (left.val == right.val);
        left = left.next;
        return check;
    }
    
    public boolean isPalindromeIter(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null)
            slow = slow.next;
        
        slow = reverseiter(slow);
        
        while(slow != null) {
            if(slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode reverseiter(ListNode head) {
        ListNode result = null;
        ListNode iter = head;
        
        while(iter != null) {
            ListNode next = iter.next;
            iter.next = result;
            result = iter;
            iter = next;
        }
        
        return result;
    }
}
