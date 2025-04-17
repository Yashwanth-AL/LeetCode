class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        arr = [-1] * n

        for i in range(n):
            for j in range(n - 1):
                index = (i + j + 1) % n
                if nums[index] > nums[i]:
                    arr[i] = nums[index]
                    break
        return arr
