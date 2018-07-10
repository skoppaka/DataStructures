/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //return mergeTwoListsIter(l1, l2);
        return mergeTwoListsRec(l1, l2);
    }
    public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        ListNode iter;
        
        if(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                iter = l1;
                iter.next = mergeTwoListsRec(l1.next, l2);
            }else {
                iter = l2;
                iter.next = mergeTwoListsRec(l1, l2.next);
            }
        }
        else
            iter = (l1 != null?l1:l2);
        
        return iter;
    }
    public ListNode mergeTwoListsIter(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                iter.next = l1;
                l1 = l1.next;
            }else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        
        iter.next = (l1 != null?l1:l2);
        
        return dummy.next;
    }
}
