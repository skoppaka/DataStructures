/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null) {
            int x = (l1 != null ? l1.val : 0);
            int y = (l2 != null ? l2.val : 0);
            sum = carry + x + y;
            carry = sum /10;
            sum = sum % 10;
            
            if(l1 != null) {
                l1.val = sum;
                iter.next = l1;
            }
            else if(l2 != null) {
                l2.val = sum;
                iter.next = l2;
            }
            
            iter = iter.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if(carry != 0) {
            iter.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
