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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!= null && fast.next!= null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        ListNode ans = merge(head1,head2);
        return ans;
    }
    static ListNode merge(ListNode head1 , ListNode head2){
    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;

    while(head1 != null && head2 != null){
        if(head1.val <= head2.val){
            tail.next = head1;
            head1 = head1.next;
        } else {
            tail.next = head2;
            head2 = head2.next;
        }
        tail = tail.next;
    }

    if(head1 != null) tail.next = head1;
    if(head2 != null) tail.next = head2;

    return dummy.next;
}

}