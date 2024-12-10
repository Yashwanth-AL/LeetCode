class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] guard : guards) grid[guard[0]][guard[1]] = 1; //mark all guards as 1
        for(int[] wall : walls) grid[wall[0]][wall[1]] = 2; //mark all walls as 2

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] guard : guards) {
            for(int[] direction : directions) {
                int x = guard[0];
                int y = guard[1];
                while(true) {
                    x += direction[0];
                    y += direction[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1 || grid[x][y] == 2){
                        break;
                    }
                    if(grid[x][y] == 0){
                        grid[x][y] = -1;
                    }
                }
            }
        }

        int unguarded = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    unguarded++;
                }
            }
        }
        return unguarded;
    }
}
