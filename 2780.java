class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        int totalCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalCount++;
            }
        }
        if (totalCount <= n / 2) return -1; 
        
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }
            int rightCount = totalCount - leftCount;
            if (leftCount > (i + 1) / 2 && rightCount > (n - i - 1) / 2) {
                return i;
            }
        }
        
        return -1;
    }
}
