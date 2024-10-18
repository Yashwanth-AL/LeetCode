class Solution {

    int maxOR = 0;
    int count = 0;
    
    public int countMaxOrSubsets(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            maxOR |= nums[i];
        }
        
        dfs(0, 0, nums);
        return count;
    }

    
    public void dfs(int index, int current, int[] nums) {
        
        if (index == nums.length) {
            if (current == maxOR) {
                count++;
            }
            return;
        }
      
        // 1. Exclude the current element
        dfs(index + 1, current, nums);

        // 2. Include the current element, updating the OR value
        dfs(index + 1, current | nums[index], nums);
    }
}
