class Solution {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int start, int end) {
        if(start >= end) return 0;

        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        int j = mid + 1;
        for(int i = start; i <= mid; i++) {
            while(j <= end && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        merge(nums, start, mid, end);
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (int index = 0; index < temp.length; index++) {
            nums[left + index] = temp[index];
        }
    }
}
