class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        int prefixSum = 0;

        for(int num : nums) {
            prefixSum += num;
            int key = prefixSum - goal;
            if(map.containsKey(key)){
                result += map.get(key);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}
