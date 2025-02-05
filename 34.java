class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if(nums.length == 0) 
            return new int[]{-1, -1};

        while(start <= end) { 
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                int first = mid, last = mid;
                while(first > 0 && nums[first - 1] == nums[first]){
                    first--;
                }
                while(last < nums.length - 1 && nums[last + 1] == nums[last]) {
                    last++;
                }
                return new int[]{first, last};
            } else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
