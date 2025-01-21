class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long sumRow0 = 0, sumRow1 = 0, result = Long.MAX_VALUE;

        // Calculate the total sum of the first row
        for (int val : grid[0]) {
            sumRow0 += val;
        }

        for (int i = 0; i < n; i++) {
            sumRow0 -= grid[0][i]; // Remove current cell from row 0
            long secondRobotScore = Math.max(sumRow0, sumRow1);
            result = Math.min(result, secondRobotScore);
            sumRow1 += grid[1][i]; // Add current cell to row 1
        }

        return result;
    }
}
