class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        prefix = defaultdict(int)
        prefix[0] = 1
        count = 0
        result = 0

        for num in nums:
            if num % 2 == 1:
                count += 1
            result += prefix[count - k]
            prefix[count] += 1

        return result
