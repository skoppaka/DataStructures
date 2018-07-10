/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //return hasCycleHash(head);
        return hasCycleLoop(head);
        
    }
    
    public boolean hasCycleHash(ListNode head) {
        Set<ListNode> hasher = new HashSet<ListNode>();
        while(head != null) {
            if(hasher.contains(head))
                return true;
            else
                hasher.add(head);
            
            head = head.next;
        }
        return false;
    }
    
    public boolean hasCycleLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        return false;
    }
}
