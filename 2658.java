class Solution {

    int directions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0 && visited[i][j] != true) {
                    max = Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true || grid[i][j] == 0){
            return 0;
        }

        visited[i][j] = true;
        int fishCount = grid[i][j];
        for(int direction[] : directions) {
            int x = direction[0] + i;
            int y = direction[1] + j;
            fishCount += dfs(grid, x, y, visited);
        }
        return fishCount;
    }
}
