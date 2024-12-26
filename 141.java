public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> node = new HashSet<>();
        ListNode current = head;

        while(current != null) {
            if(node.contains(current)){
                return true;
            }
            node.add(current);
            current = current.next;
        }
        return false;
    }
}
