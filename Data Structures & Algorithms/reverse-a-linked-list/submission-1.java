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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null)
        {
            // get the next node
            next = curr.next;
            
            // reverse current node's next pointer
            // head will point to null (last node)
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
