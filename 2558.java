class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;
        for(int gift : gifts) {
            heap.offer(gift);
            sum += gift;
        }

        for(int i = 0; i < k; i++){
            int polled = heap.poll();
            int value = (int) Math.sqrt(polled);
            sum = sum - polled + value;
            heap.offer(value);
        }
        return sum;
    } 
}
