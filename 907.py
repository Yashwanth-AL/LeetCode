class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        n = len(arr)
        mod = 10 ** 9 + 7

        prev_smaller = [-1] * n
        next_smaller = [n] * n
        stack = []

        for i in range(n):
            while stack and arr[stack[-1]] > arr[i]:
                stack.pop()
            prev_smaller[i] = stack[-1] if stack else -1
            stack.append(i)
         
        stack.clear()
        
        for i in range(n-1, -1, -1):
            while stack and arr[stack[-1]] >= arr[i]:
                stack.pop()
            next_smaller[i] = stack[-1] if stack else n
            stack.append(i)

        result = 0
        for i in range(n):
            left = i - prev_smaller[i]
            right = next_smaller[i] - i
            result = (result + arr[i] * left * right) % mod
        
        return result
