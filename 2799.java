class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int size = set.size();

        int left = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() == size){
                result += nums.length - right;

                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
        }
        return result;
    }
}
