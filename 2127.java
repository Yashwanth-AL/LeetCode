class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegrees = new int[n];
        int[] maxDepth = new int[n];

        for (int i = 0; i < n; ++i) {
            indegrees[favorite[i]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indegrees[i] == 0) {
                queue.add(i);
                maxDepth[i] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int next = favorite[node];
            indegrees[next]--;
            maxDepth[next] = Math.max(maxDepth[next], 1 + maxDepth[node]);
            if (indegrees[next] == 0) {
                queue.add(next);
            }
        }

        int resultWithTwoNodeCycle = 0;
        int resultWithFullCycle = 0;
        int[] visited = new int[n];

        for (int i = 0; i < n; ++i) {
            if (indegrees[i] != 0 && visited[i] == 0) {
                int cycleSize = 0;
                int node = i;

                while (visited[node] == 0) {
                    visited[node] = 1;
                    node = favorite[node];
                    cycleSize++;
                }

                if (cycleSize == 2) {
                    resultWithTwoNodeCycle += maxDepth[i] + maxDepth[favorite[i]] + 2;
                } else {
                    resultWithFullCycle = Math.max(resultWithFullCycle, cycleSize);
                }
            }
        }

        return Math.max(resultWithFullCycle, resultWithTwoNodeCycle);
    }
}
