class Solution {
    public long findScore(int[] nums) {

        int n = nums.length;
        boolean[] isMarked = new boolean[nums.length];
        long score = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        for(int i = 0; i < nums.length; i++){
            heap.offer(new int[] {nums[i], i});
        }

        while(!heap.isEmpty()) {
            int[] current = heap.poll();
            int value = current[0];
            int index = current[1];

            if(isMarked[index]) continue;

            isMarked[index] = true;
            if(index - 1 >= 0) isMarked[index - 1] = true;
            if(index + 1 < n) isMarked[index + 1] = true;
            score += value;
        }
        return score;
    }
}
