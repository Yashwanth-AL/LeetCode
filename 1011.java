class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = weights[0];
        int right = 0;
        for(int num : weights) {
            left = Math.max(num, left);
            right += num;
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isValid(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isValid(int[] nums, int capacity, int days) {
        int load = 0;
        int dayCount = 1;

        for(int num : nums) {
            if(load + num > capacity) {
                dayCount++;
                load = 0;
            }
            load += num;
            if(dayCount > days) return false;
        }
        return true;
    }

}
