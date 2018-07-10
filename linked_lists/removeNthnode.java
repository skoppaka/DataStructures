/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if(head == null)
            return head;
        ListNode fir = dummy;
        ListNode sec = dummy;
        
        while(n-- >= 0) {
            sec = sec.next;
        }
        
        while(sec != null) {
            fir = fir.next;
            sec = sec.next;
        }
        
        fir.next = fir.next.next;
        return dummy.next;
    }
}
