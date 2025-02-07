class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = getMax(nums);

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isValid(nums, mid, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isValid(int[] nums, int mid, int threshold) {
        int result = 0;
        for(int num : nums) {
            result += (num + mid - 1) / mid;
        }
        return result <= threshold;
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
