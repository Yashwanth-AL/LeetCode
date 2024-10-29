class Solution {
    public int maxMoves(int[][] grid) { 

        int m = grid.length;
        int n = grid[0].length;

        Set<Integer> current = new HashSet<>();
        for(int i = 0; i < m; i++){
            current.add(i);
        }

        for(int col = 0; col < n - 1; col++){

            Set<Integer> next = new HashSet<>();

            for(int row : current){
                for(int nextRow = row - 1; nextRow <= row + 1; nextRow++){
                    if(nextRow >= 0 && nextRow < m && grid[row][col] < grid[nextRow][col+1]){
                        next.add(nextRow);
                    }
                }
            }

            if(next.isEmpty()){
                return col;
            }
            current = next;
        }
        return n - 1;
    }
}
