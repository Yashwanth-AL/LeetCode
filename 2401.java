class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int maxLength = 1;
        int current = 0;
        for(int right = 0; right < nums.length; right++) {
            while((current & nums[right]) != 0) {
                current ^= nums[left];
                left++;
            }
            current |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
