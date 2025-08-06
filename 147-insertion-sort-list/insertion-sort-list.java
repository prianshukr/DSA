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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0); // Dummy node
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;

            // Find the correct spot to insert current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Save next node to continue later
            ListNode nextTemp = curr.next;

            // Insert current node in sorted list
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in original list
            curr = nextTemp;
        }

        return dummy.next;
    }
}