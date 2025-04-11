class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        map = {}
        n = len(nums2)

        for i in range(n):
            key = nums2[i]
            value = -1
            for j in range(i + 1, n):
                if nums2[j] > key:
                    value = nums2[j]
                    break
            
            map[key] = value

        return [map[num] for num in nums1]
