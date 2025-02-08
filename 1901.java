class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int start = 0;
        int end = cols - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            int rowIndex = findMax(mat, mid);
            int value = mat[rowIndex][mid];

            int left = (mid - 1 >= 0) ? mat[rowIndex][mid - 1] : -1;
            int right = (mid + 1 < cols) ? mat[rowIndex][mid + 1] : -1;

            if (value > left && value > right) {
                return new int[]{rowIndex, mid}; 
            } else if (value < left) {
                end = mid - 1; 
            } else {
                start = mid + 1;
            }
            
        }
        return new int[]{-1, -1};
    }

    public int findMax(int[][] mat, int col) {
        int rows = mat.length;
        int maxIndex = 0;
        
        for (int i = 1; i < rows; i++) {
            if (mat[i][col] > mat[maxIndex][col]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
