class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total_sum = Arrays.stream(nums).sum();

        if ((total_sum + target) % 2 != 0 || total_sum + target < 0) {
            return 0;
        }

        int target_sum = (total_sum + target) / 2;
        int dp[] = new int[target_sum + 1];
        
        Arrays.fill(dp, 0);
        dp[0] = 1; 

        for (int num : nums) {
            for (int j = target_sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target_sum];
    }
}
