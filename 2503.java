public class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[queries.length];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        // Min-heap to prioritize cells with the smallest values
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        
        // Sort queries with their indices for result tracking
        int[][] indexedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            indexedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[0]));
        
        int points = 0;
        
        for (int[] query : indexedQueries) {
            int threshold = query[0];
            int index = query[1];
            
            // Expand cells while the smallest value is below the threshold
            while (!minHeap.isEmpty() && minHeap.peek()[0] < threshold) {
                int[] cell = minHeap.poll();
                int value = cell[0], x = cell[1], y = cell[2];
                points++;
                
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        minHeap.offer(new int[]{grid[nx][ny], nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            result[index] = points;
        }
        
        return result;
    }
}
