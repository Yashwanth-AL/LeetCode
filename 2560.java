class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        int result = right;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(canRob(nums, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private boolean canRob(int[] nums, int k, int mid) {
        int count = 0;
        int i = 0;

        while(i < nums.length) {
            if(nums[i] <= mid) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        return count >= k;
    }
}
