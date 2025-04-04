class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long maxSum = 0;

        for(int i = 0; i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }

        if(map.size() == k){
            maxSum = sum;
        }

        for(int i = k; i < n; i++){

            //Remove the outgoing element from the array
            map.put(nums[i-k], map.getOrDefault(nums[i-k], 1) - 1);
            if(map.get(nums[i-k]) == 0){
                map.remove(nums[i-k]);
            }
            
            //Add the incomming element
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i] - nums[i-k];

            if(map.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
