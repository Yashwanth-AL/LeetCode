class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        total = sum(cardPoints)
        length = len(cardPoints) - k
        current = sum(cardPoints[:length])
        min_subarray = current

        for i in range(length, len(cardPoints)):
            current += cardPoints[i] - cardPoints[i - length]
            min_subarray = min(min_subarray, current)
        
        return total - min_subarray
