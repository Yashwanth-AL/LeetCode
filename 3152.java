class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
       
        int n = nums.length;
        int[] prefix = new int[n];
        boolean[] result = new boolean[queries.length];

        for(int i = 0; i < n-1; i++) {
            prefix[i + 1] = prefix[i];
            if(nums[i] % 2 == nums[i + 1] % 2) {
                prefix[i + 1]++;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            if(prefix[from] == prefix[to]){
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
