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
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        Deque<Integer> deque = new LinkedList<>();

        while(current != null) {
            deque.offerFirst(current.val);
            current = current.next;
        }
        
        while(!deque.isEmpty())  {
            int first = deque.pollFirst();
            int last;

            if(deque.isEmpty()) {
                last = first;
            } else {
                last = deque.pollLast();
            }

            if(first != last){
                return false;
            }
        }
        return true;
    }
}
