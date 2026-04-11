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
    public boolean hasCycle(ListNode head) {
        /*
        Slow and fast pointers for linked list.
        Slow goes by 1. Fast goes by 2.
        If there is a cycle, linkedlist traversal will go on forever.
        but if you go skip a step, eventually you will get a null.
        */

        // starting at the starting line
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null)
        {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare)
            {
                return true;
            }
        }

        return false;
    }
}
