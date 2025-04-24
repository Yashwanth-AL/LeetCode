class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        size = len(set(nums))

        result = 0
        left = 0
        freq = defaultdict(int)

        for right in range(len(nums)):
            freq[nums[right]] += 1

            while len(freq) == size:
                result += len(nums) - right
                freq[nums[left]] -= 1
                if freq[nums[left]] == 0:
                    del freq[nums[left]]
                left += 1
        
        return result
