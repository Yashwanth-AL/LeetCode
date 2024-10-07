class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){

            //check it the list has duplicates
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            int pivot = nums[i];
            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = nums[left] + nums[right] + pivot;
                if(sum == 0){
                    list.add(Arrays.asList(pivot, nums[left], nums[right]));

                    //skip the duplicate elements
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }

                    left++;
                    right--;

                }else if(sum > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return list;
    }
}
