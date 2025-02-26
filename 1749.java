class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        int currentMax = 0;
        int currentMin = 0;

        for(int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            max = Math.max(max, currentMax);

            currentMin = Math.min(num, currentMin + num);
            min = Math.min(min, currentMin);
        }

        return Math.max(Math.abs(max), Math.abs(min));
    }
}
