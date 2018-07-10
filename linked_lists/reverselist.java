/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //ListNode result = reverseiter(head);
        ListNode result = reverserec(head);
        return result;
    }
    
    public ListNode reverserec(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode first = head;
        ListNode rest = head.next;
        
        rest = reverserec(rest);
        
        first.next.next = first;
        first.next = null;
        
        
        return rest;
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
