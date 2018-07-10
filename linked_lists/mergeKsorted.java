/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    static class NodeCmp implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return (a.val - b.val);
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length <1)
            return null;
        else if(lists.length == 1)
            return lists[0];
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new NodeCmp());
        
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                minHeap.add(lists[i]);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
            if(tail.next != null)
                minHeap.add(tail.next);
        }
        
        return dummy.next;
        
        
    }
}
