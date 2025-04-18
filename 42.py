class Solution:
    def trap(self, height: List[int]) -> int:
        l = len(height)

        left = [0] * l
        left[0] = height[0]
        for i in range(1, l):
            left[i] = max(left[i-1], height[i])
        
        right = [0] * l
        right[l-1] = height[l-1]
        for i in range(l-2, -1, -1):
            right[i] = max(right[i+1], height[i])

        result = 0
        for i, val in enumerate(height):
            result += min(left[i], right[i]) - val
        
        return result
