class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        for(String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        int n = nums[0].length();
        for(int i = 0; i < (1 << n); i++) {
            if(!set.contains(i)) {
                String value = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(" ", "0");
                return value;
            }
        }
        
        return "";
    }
}
