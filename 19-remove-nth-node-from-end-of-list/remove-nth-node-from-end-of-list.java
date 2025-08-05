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
    static int len(ListNode head){
        int count=0;
        while(head!= null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
      
        if(n == len(head)) return head.next;
        ListNode temp = head;
        for(int i=1;i<len(head)-n;i++) temp = temp.next;
        if(temp!=null || temp.next!=null)temp.next = temp.next.next;
        return head;
    }
}