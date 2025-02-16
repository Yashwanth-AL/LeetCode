class Solution {
    
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(1, k, n, new ArrayList<>());
        return result;
    }

    public void backTrack(int start, int k, int target, List<Integer> list) {
        if(list.size() == k && target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if(list.size() >= k || target < 0) return;

        for(int i = start; i <= 9; i++) {
            list.add(i);
            backTrack(i + 1, k, target - i, list);
            list.remove(list.size() - 1);
        }
    }
}
