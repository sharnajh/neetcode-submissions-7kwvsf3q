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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode list : lists)
        {
            while (list != null)
            {
                q.add(list);
                list = list.next;
            }
        }

        ListNode merged = new ListNode();
        ListNode curr = merged;
        while (!q.isEmpty())
        {
            curr.next = q.poll();
            curr = curr.next;
        }

        return merged.next;
    }
}
