class Solution {
    public int countKDifference(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            result += map.getOrDefault(num - k, 0);
            result += map.getOrDefault(num + k, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}
