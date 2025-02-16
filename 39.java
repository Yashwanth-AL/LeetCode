class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, new ArrayList<>(), 0);
        return result;    
    }

    public void backTrack(int[] candidates, int target, List<Integer> list, int index) {
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                list.add(candidates[i]);
                backTrack(candidates, target - candidates[i], list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
