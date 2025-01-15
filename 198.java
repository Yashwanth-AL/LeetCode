class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; 
        if (n == 1) return nums[0];

        int prev = nums[0];
        int current = Math.max(nums[1], nums[0]);

        for(int i = 2; i < n; i++) {
            int next = Math.max(prev + nums[i], current);
            prev = current;
            current = next;
        }

        return current;
    }
}
