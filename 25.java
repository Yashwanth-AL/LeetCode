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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevEnd = dummy;
        ListNode current = head;

        while(true) {
            ListNode kthNode = getKthNode(current, k);
            if(kthNode == null){
                prevEnd.next = current;
                break;
            }
                

            ListNode nextStart = kthNode.next;
            ListNode reversed = reverse(current, kthNode);
            
            prevEnd.next = reversed;
            prevEnd = current;
            current = nextStart;

        }
        return dummy.next;

    }

    public ListNode getKthNode(ListNode head, int k) {
        while(head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode current = head;
        ListNode prev = null; 
        ListNode end = tail.next;

        while(current != end) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
