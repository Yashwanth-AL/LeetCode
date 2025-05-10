import heapq

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []

        for node in lists:
            while node:
                heapq.heappush(heap, node.val)
                node = node.next

        head = ListNode(0)
        current = head

        while heap:
            current.next = ListNode(heapq.heappop(heap))
            current = current.next

        return head.next
