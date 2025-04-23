from collections import Counter

class Solution:
    def countLargestGroup(self, n: int) -> int:
        count_map = Counter()

        for i in range(1, n+1):
            digit_sum = sum(map(int, str(i)))
            count_map[digit_sum] += 1

        max_size = max(count_map.values())
        return sum(1 for size in count_map.values() if size == max_size)
