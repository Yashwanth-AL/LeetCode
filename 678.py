class Solution:
    def checkValidString(self, s: str) -> bool:
        high = 0
        low = 0

        for c in s:
            if c == '(':
                high += 1
                low += 1
            elif c == ')':
                if low > 0: low -= 1
                high -= 1
            else:
                if low > 0: low -= 1
                high += 1
            if high < 0:
                return False
        
        return low == 0
            
