class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}

        for i, num in enumerate(nums):
            if target - num in map:
                return [map[target - num], i]
            map[num] = i

"""
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
"""
