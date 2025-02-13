class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> valid = new PriorityQueue<>();
        PriorityQueue<Long> inValid = new PriorityQueue<>();
        int op_count = 0;

        for(int num : nums) {
            if(num < k) {
                inValid.add((long) num);
            } else {
                valid.add((long) num);
            }
        }

        while(!inValid.isEmpty()) {
            long x = inValid.poll();
            long y;
            if(inValid.isEmpty()) {
                y = valid.poll();
            } else {
                y = inValid.poll();
            } 

            long value = Math.min(x, y) * 2 + Math.max(x, y);
            op_count++;

            if(value < k) {
                inValid.add(value);
            } else {
                valid.add(value);
            }
        }

        return op_count;
    }
}
