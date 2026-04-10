/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    /**
                
        null -> 0 -> 1 -> 2 -> 3 -> null
             <- 0  
    **/
    public ListNode reverseList(ListNode head) {
        // curr = head
        ListNode curr = head;
        // prev = null
        ListNode prev = null;
        // next = null
        ListNode next;

        while (curr != null)
        {
            next = curr.next; // keep track of the next node
            
            // this is flip time
            curr.next = prev; // point next to previous node to flip

            // iteration step
            prev = curr; // make prev node
            curr = next;
        }
    
        // curr will be null by end of traversal
        // so return prev
        return prev;
    }
}
