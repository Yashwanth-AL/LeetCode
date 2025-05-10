class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(ListNode node : lists) {
            while(node != null) {
                heap.add(node.val);
                node = node.next;
            }
        }

        ListNode head = new ListNode();
        ListNode node = head;
        while(!heap.isEmpty()) {
            node.next = new ListNode(heap.poll());
            node = node.next;
        }
        return head.next;
    }
}
