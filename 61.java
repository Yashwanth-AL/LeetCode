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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode last = head;
        int count = 1;

        while(last.next != null) {
            last = last.next;
            count++;
        }
        last.next = head;
        last = head;
        k = k % count;

        for(int i = 1; i < count - k; i++) {
            last = last.next;
        }
        ListNode first = last.next;
        last.next = null; 
        return first;
    }
}
