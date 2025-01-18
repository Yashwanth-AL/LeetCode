class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[m][n];

        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);

        // Start from (0,0) with cost 0
        deque.offer(new int[]{0, 0, 0});
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int x = curr[0], y = curr[1], currCost = curr[2];

            if (x == m - 1 && y == n - 1) return currCost;

            for (int d = 0; d < 4; d++) {
                int nx = x + directions[d][0], ny = y + directions[d][1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newCost = currCost + (grid[x][y] == d + 1 ? 0 : 1);

                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        if (grid[x][y] == d + 1) {
                            deque.addFirst(new int[]{nx, ny, newCost});
                        } else {
                            deque.addLast(new int[]{nx, ny, newCost});
                        }
                    }
                }
            }
        }
        return -1; 
    }
}
