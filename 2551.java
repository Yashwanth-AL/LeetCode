import java.util.*;

public class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[] pairSum = new long[n - 1];

        // Calculate adjacent pair sums
        for (int i = 0; i < n - 1; i++) {
            pairSum[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairSum);

        long maxScore = 0;
        long minScore = 0;

        // Calculate max and min score using the sorted pairs
        for (int i = 0; i < k - 1; i++) {
            maxScore += pairSum[n - 2 - i];
            minScore += pairSum[i];
        }

        return maxScore - minScore;
    }
}
