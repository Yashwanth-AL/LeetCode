class Solution {
    public long continuousSubarrays(int[] nums) {
        int left = 0;
        long total = 0;

        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();

        for(int right = 0; right < nums.length; right++) {
            while(!max.isEmpty() && nums[right] > nums[max.peekLast()]) {
                max.pollLast();
            }
            max.addLast(right);

            while(!min.isEmpty() && nums[right] < nums[min.peekLast()]) {
                min.pollLast();
            }
            min.addLast(right);

            while(nums[max.peekFirst()] - nums[min.peekFirst()] > 2) {
                left++;
                if(max.peekFirst() < left) max.pollFirst();
                if(min.peekFirst() < left) min.pollFirst();
            }

            total += right - left + 1;
        }

        return total;

    }
}
