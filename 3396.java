class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = -1;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(set.contains(nums[i])){
                index = i;
                break;
            } else {
                set.add(nums[i]);
            }
        }
        return index == -1 ? 0 : (index / 3 + 1);
    }
}
