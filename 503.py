class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        arr = [-1] * n

        stack = []
        for i in range(2 * n - 1, -1, -1):
            while stack and stack[-1] <= nums[i % n]:
                stack.pop()

            if i < n:
                arr[i] = stack[-1] if stack else -1

            stack.append(nums[i % n])
        
        return arr


        # n = len(nums)
        # arr = [-1] * n

        # for i in range(n):
        #     for j in range(n - 1):
        #         index = (i + j + 1) % n
        #         if nums[index] > nums[i]:
        #             arr[i] = nums[index]
        #             break
        # return arr
