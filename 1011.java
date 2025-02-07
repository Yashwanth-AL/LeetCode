class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = getMax(weights);
        int right = getSum(weights);

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

   public int getMax(int[] arr) {
        int max = arr[0];
        for(int num : arr) {
            max = Math.max(num, max);
        }
        return max;
    }

    public int getSum(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result += num;
        }
        return result;
    }
}
