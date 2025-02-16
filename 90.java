class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 <<  (n - j - 1))) != 0){
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        
        Set<List<Integer>> unique = new LinkedHashSet<>(result);
        return new ArrayList<>(unique);
    }
}
