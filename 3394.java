import java.util.Arrays;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {

        int[][] xIntervals = new int[rectangles.length][2];
        int[][] yIntervals = new int[rectangles.length][2];
        
        for (int i = 0; i < rectangles.length; i++) {
            xIntervals[i][0] = rectangles[i][0]; 
            xIntervals[i][1] = rectangles[i][2]; 
            yIntervals[i][0] = rectangles[i][1]; 
            yIntervals[i][1] = rectangles[i][3]; 
        }
        
        // Check if either x-intervals or y-intervals can be merged into at least 3 groups.
        return Math.max(countMerged(xIntervals), countMerged(yIntervals)) >= 3;
    }
    
    private int countMerged(int[][] intervals) {
        int count = 0;
        // Initialize prevEnd with a value less than any possible start.
        int prevEnd = -1;  
        
        // Sort intervals by their starting coordinate.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            // If the current interval's start is at or after prevEnd,
            // we can form a new group (i.e. there's a gap).
            if (start >= prevEnd) {
                count++;
                prevEnd = end;
            } else {
                // Otherwise, merge by extending the end boundary.
                prevEnd = Math.max(prevEnd, end);
            }
        }
        return count;
    }
}
