class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        int xor = 0;

        for(int num : nums){
            xor ^= num;
        }

        int max = (1 << maximumBit) - 1;

        for(int i = 0; i < n; i++){
            result[i] = max ^ xor;
            xor ^= nums[n-i-1];
        }
        return result;
    }
}
