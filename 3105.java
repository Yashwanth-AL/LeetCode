class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int increasing = 1;
        int decreasing = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                increasing++;
            } else {
                max = Math.max(increasing, max);
                increasing = 1;
            }

            if(nums[i] < nums[i-1]){
                decreasing++;
            } else {
                max = Math.max(decreasing, max);
                decreasing = 1;
            }
        }  
        max = Math.max(max, increasing);
        max = Math.max(max, decreasing);
        return max;  
    }
}
