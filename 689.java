class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        
        // Step 1: Compute prefix sums.
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Step 2: Calculate sum for each subarray of size k.
        int[] subarraySum = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            subarraySum[i] = prefixSum[i + k] - prefixSum[i];
        }

        // Step 3: DP array for the best subarrays.
        int[] left = new int[n - k + 1];  // left[i] is the index of the best subarray [0...i]
        int[] right = new int[n - k + 1]; // right[i] is the index of the best subarray [i...n-k]

        // Fill left array: Best subarray from the left up to index i.
        for (int i = 0; i < n - k + 1; i++) {
            if (i == 0 || subarraySum[i] > subarraySum[left[i - 1]]) {
                left[i] = i;
            } else {
                left[i] = left[i - 1];
            }
        }

        // Fill right array: Best subarray from the right starting from index i.
        for (int i = n - k; i >= 0; i--) {
            if (i == n - k || subarraySum[i] >= subarraySum[right[i + 1]]) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }

        // Step 4: Find the best result by checking combinations of left, middle, and right subarrays.
        int maxSum = 0;
        int[] result = new int[3];
        for (int middle = k; middle <= n - 2 * k; middle++) {
            int leftIndex = left[middle - k];
            int rightIndex = right[middle + k];
            int totalSum = subarraySum[leftIndex] + subarraySum[middle] + subarraySum[rightIndex];

            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = leftIndex;
                result[1] = middle;
                result[2] = rightIndex;
            }
        }

        return result;
    }
}
