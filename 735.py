class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for asteroid in asteroids:
            if asteroid > 0:
                stack.append(asteroid)
            else:
                while stack and stack[-1] > 0:
                    if stack[-1] < abs(asteroid):
                        stack.pop()
                        continue
                    elif stack[-1] == abs(asteroid):
                        stack.pop()
                        break
                    else:
                        break
                else:
                    stack.append(asteroid)
            
        return stack
