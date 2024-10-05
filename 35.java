class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
    public static int binarySearch(int arr[], int beg, int end, int key){
        int mid = (beg + end) / 2;
        if(beg > end){
            return end+1;
        }
        if (arr[mid] == key){
            return mid;
        } else if(key > arr[mid]){
            return binarySearch(arr, mid+1, end, key);
        } else {
            return binarySearch(arr, beg, mid-1, key);
        }
    }
}
