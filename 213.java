class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int case1 = robLinear(nums, 0, n - 2);
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    public int robLinear(int nums[], int start, int end) {
        int prev = 0;
        int current = 0;
        for(int i = start; i <= end; i++) {
            int next = Math.max(prev + nums[i], current);
            prev = current;
            current = next;
        }
        return current;
    }
}
