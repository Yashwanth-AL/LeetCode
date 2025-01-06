class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int bits[] = new int[n];
        for(int i = 0; i < n; i++) {
            bits[i] = boxes.charAt(i) - '0';
        }

        int result[] = new int[n];
        int prefix[] = new int[n + 1];
        int suffix[] = new int[n + 1];
        int leftCost = 0;
        int rightCost = 0;

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + bits[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + bits[i + 1];
            rightCost += suffix[i];
        }

        for(int i = 0; i < n; i++) {
            result[i] = leftCost + rightCost;
            rightCost -= suffix[i];
            leftCost += prefix[i + 1];
        }
        return result;
    }
}
