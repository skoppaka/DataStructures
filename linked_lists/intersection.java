/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode shiftbyK(ListNode head, int k) {
        while(k-- > 0) {
            head = head.next;
        }
        return head;
    }
    
    int length(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        
        if(lenA < lenB)
            headB = shiftbyK(headB, lenB - lenA);
        else
            headA = shiftbyK(headA, lenA - lenB);
        
        while(headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}
