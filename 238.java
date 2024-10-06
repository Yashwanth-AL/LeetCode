class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];

        //first caluclate prefix product
        arr[0] = 1;
        for(int i = 1; i < n; i++){
            arr[i] = nums[i-1] * arr[i-1];
        }

        //caluclate suffix product and multiply with prefix product
        int suffix = 1;
        for(int i = n-1; i >= 0; i--){
            arr[i] *= suffix;
            suffix *= nums[i];
        }
        return arr;
    }
}
