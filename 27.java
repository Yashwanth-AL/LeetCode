class Solution {
    public int removeElement(int[] nums, int val) {
        int[] arr = new int[nums.length];
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                arr[k++] = nums[i];
            }
        }
        for(int i = 0; i < k; i++){
            nums[i] = arr[i];
        }
        return k;
    }
}
