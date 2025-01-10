class Solution {
    public void sortColors(int[] nums) {
        //Dutch national flag algorithm
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int i = 0;

        while(i <= right) {
            if(nums[i] == 0) {
                swap(nums, i++, left++);
            } else if(nums[i] == 2) {
                swap(nums, i, right--);
            } else {
                i++;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
