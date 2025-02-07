class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int length = (int) Math.floor(nums.length / 3);

        map.forEach((key, value) -> {
            if(value > length) {
                list.add(key);
            }
        });
        
        return list;

    }
}
