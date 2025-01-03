class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0;

        for(int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        long prefixSum = 0;
        int count = 0;

        for(int i = 0; i < n-1; i++) {
            prefixSum += nums[i];
            long rightSum = totalSum - prefixSum;
            if(prefixSum >= rightSum) {
                count++;
            }
        }

        return count;
    }
}
