class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long) m * k > n) {
            return -1;
        }
        int left = getMin(bloomDay);
        int right = getMax(bloomDay);

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isValid(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isValid(int[] nums, int m, int k, int mid) {
        int bouquets = 0;
        int flowers = 0;
        for(int num : nums) {
            if(num <= mid) {
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            if(bouquets >= m) return true;
        }
        return false;
    }

    public int getMin(int[] arr) {
        int min = arr[0];
        for(int num : arr) {
            if(num < min) {
                min = num;
            }
        }
        return min;
    }

    public int getMax(int[] arr) {
        int max = arr[0];
        for(int num : arr) {
            if(num > max) {
                max = num;
            }
        }
        return max;
    }
}
