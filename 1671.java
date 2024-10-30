class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];

        for(int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        //Caluclate longest increasing subsequene(LIS)
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i-1; j++){
                if(nums[j] < nums[i]){
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        //Caluclate the longest decreasing subsequence(LDS)
        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(nums[j] < nums[i]){
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 1; i < n-1; i++){
            if(left[i] > 1 && right[i] > 1){
                int mountainLength = left[i] + right[i] - 1;
                max = Math.max(mountainLength, max);
            }
        }

        return max > 0 ? n - max : 0;
    }
}
