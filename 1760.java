class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();

        while(left < right){
            int mid = (left + right) / 2;
            if(isValid(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isValid(int[] nums, int maxBalls, int maxOperations) {
        int operations = 0;
        for(int balls : nums) {
            operations += (balls - 1) / maxBalls;
        }
        return operations <= maxOperations;
    }
}
