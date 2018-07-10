/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode carry_pos = dummy;
        ListNode adder_pos = dummy;
        
        while(adder_pos.next != null) {
            adder_pos = adder_pos.next;
            
            if(adder_pos.val != 9)
                carry_pos = adder_pos;
        }
        
        if(adder_pos.val != 9)
            adder_pos.val += 1;
        else {
            carry_pos.val += 1;
            while(carry_pos.next != null) {
                carry_pos = carry_pos.next;
                carry_pos.val = 0;
            }
        }
        
        if(dummy.val == 0)
            return dummy.next;
        
        return dummy;
    }
}
