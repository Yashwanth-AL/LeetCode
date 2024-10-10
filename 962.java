class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();

       //stack content should be such that the lowest element index is in the top of the stack

       stack.push(0);
       for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[stack.peek()])
                stack.push(i);
       }

       int max = 0;
       for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                max = Math.max(max, i - stack.pop());
            }
       }
       return max;
    }
}
