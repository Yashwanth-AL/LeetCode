class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long totalSum = 0;
        int left = 0;
        int maxFrequency = 0;

        for(int right = 0; right < nums.length; right++){
            totalSum += nums[right];

            while((long) nums[right] * (right - left + 1) - totalSum > k){
                totalSum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}
