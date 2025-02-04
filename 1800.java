class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];

        int left = 0;
        int right = 1;
        int current = nums[0];

        while(right < nums.length) {
            if(nums[right] > nums[left]) {
                current += nums[right];
            } else {
                current = nums[right];
            }
            maxSum = Math.max(current, maxSum);
            right++;
            left++;
        }
        return maxSum;
    }
}
