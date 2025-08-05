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
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = len(head);
        int group = n/k;
        ListNode prevH = null;
        ListNode currH = head;
        ListNode ansN = null;
        for(int i=0;i<group;i++){
            ListNode prev = null;
            ListNode curr = currH;
            ListNode nxt = null;

            for(int j=0;j<k;j++){
                nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }

            if(prevH == null) ansN = prev;
            else prevH.next = prev;

            prevH = currH;
            currH = curr;
        }
        prevH.next = currH;
        return ansN;
    }
}