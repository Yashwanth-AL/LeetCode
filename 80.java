class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int k = 1;
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                count = 0;
                nums[k++] = nums[i];
            } else if(nums[i] == nums[i-1] && count < 1){
                nums[k++] = nums[i];
                count++;
            }
        }
        return k;
    }
}
