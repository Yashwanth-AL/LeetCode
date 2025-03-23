class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int road[] : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        long dist[] = new long[n];
        int ways[] = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});

         while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currDist = curr[0];
            int node = (int) curr[1];

            if (currDist > dist[node]) continue;

            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                long weight = neighbor[1];
                long newDist = currDist + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{newDist, nextNode});
                } else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}
