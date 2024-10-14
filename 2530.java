class Solution {
    public long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < nums.length; i++){
            heap.add(nums[i]);
        }

        long maxValue = 0;
        for(int i = 0; i < k; i++){
            int polled = heap.poll();
            maxValue += (long) polled;
            heap.add((int) Math.ceil(polled / 3.0));
        }
        
        return maxValue;
    }

}
