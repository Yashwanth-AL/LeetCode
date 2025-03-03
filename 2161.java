class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> lesser = new LinkedList<>();
        Queue<Integer> greater = new LinkedList<>();
        int equal = 0;

        for(int num : nums) {
            if(num < pivot) {
                lesser.offer(num);
            } else if(num == pivot) {
                equal++;
            } else {
                greater.offer(num);
            }
        }

        int i = 0;
        while(!lesser.isEmpty()) {
            nums[i++] = lesser.poll();
        }

        for(int j = 0; j < equal; j++) {
            nums[i++] = pivot;
        }

        while(!greater.isEmpty()) {
            nums[i++] = greater.poll();
        }

        return nums;
    }
}
