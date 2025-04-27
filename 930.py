class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        count = defaultdict(int)
        count[0] = 1
        prefixsum = 0
        result = 0

        for num in nums:
            prefixsum += num
            result += count[prefixsum - goal]
            count[prefixsum] += 1
        
        return result
