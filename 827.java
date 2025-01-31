import java.util.*;

class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        int islandId = 2; // Start labeling islands from 2
        Map<Integer, Integer> islandSize = new HashMap<>();
        boolean hasZero = false;

        // Step 1: Label each island and store their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSize.put(islandId, size);
                    islandId++;
                } else {
                    hasZero = true; // At least one zero exists
                }
            }
        }

        // Step 2: Get the largest existing island
        int maxIsland = islandSize.values().stream().max(Integer::compare).orElse(0);
        if (!hasZero) return n * n; // No zeros means the entire grid is one big island

        // Step 3: Try flipping each 0 to 1 and check new island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int newSize = 1; // Flip the 0 to 1, count itself

                    for (int[] d : directions) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            int id = grid[ni][nj];
                            if (!seen.contains(id)) {
                                newSize += islandSize.get(id);
                                seen.add(id);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }

    // DFS function to explore an island and calculate its size
    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = id; // Mark this cell with the island ID
        int size = 1;
        for (int[] d : directions) {
            size += dfs(grid, i + d[0], j + d[1], id);
        }
        return size;
    }
}
