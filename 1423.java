class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for (int num : cardPoints) {
            total += num;
        }

        int len = cardPoints.length - k;
        if (len == 0) return total; 

        int current = 0;
        for (int i = 0; i < len; i++) {
            current += cardPoints[i];
        }

        int minSubarraySum = current;
        for (int i = len; i < cardPoints.length; i++) {
            current += cardPoints[i] - cardPoints[i - len];
            minSubarraySum = Math.min(minSubarraySum, current);
        }

        return total - minSubarraySum;
    }
}
