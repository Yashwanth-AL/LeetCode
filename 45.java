class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int jumps = 0;
        int currentEnd = 0;
        int farthestEnd = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthestEnd = Math.max(farthestEnd, nums[i] + i);
            if(i == currentEnd){
                jumps++;
                currentEnd = farthestEnd;
            }
            if(currentEnd >= nums.length - 1)
                break;
        }
        return jumps;
    }
}
