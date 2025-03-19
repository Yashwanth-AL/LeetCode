public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> que = new LinkedList<>();
        int min = Integer.MAX_VALUE;

        long prefixSum[] = new long[n+1];
        for(int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        for(int i = 0; i <= n; i++){
            while(!que.isEmpty() && prefixSum[i] - prefixSum[que.peekFirst()] >= k ){
                min = Math.min(min, i - que.pollFirst());
            }
            while(!que.isEmpty() && prefixSum[i] <= prefixSum[que.peekLast()]){
                que.pollLast();
            }
            que.addLast(i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
