class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            ListNode current = temp;
            while(current.next != null && current.val == current.next.val) {
               current = current.next;
            }
            temp.next = current.next;
            temp = temp.next;
        }
        return head;
    }
}
