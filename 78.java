class Solution {

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        generate(nums, 0, new ArrayList<>());
        return result;
    }

    private void generate(int[] nums, int index, List<Integer> list) {
        if(index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        generate(nums, index + 1, list);
        
        list.remove(list.size() - 1);
        generate(nums, index + 1, list);
    }
}
