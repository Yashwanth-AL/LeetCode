class Solution {
    public int tupleSameProduct(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }

        for(int count : map.values()) {
            if(count > 1) {
                result += (count * (count - 1) / 2) * 8;
            }
        }

        return result;
    }
}
