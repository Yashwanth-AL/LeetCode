class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        if len(g) == 0 or len(s) == 0:
            return 0
        
        g.sort()
        s.sort()
        index = 0
        result = 0

        for num in s:
            if index < len(g) and num >= g[index]:
                result += 1
                index += 1
        
        return result
