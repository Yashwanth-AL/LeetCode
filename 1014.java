class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxSoFar = values[0];
        int result = 0;

        for(int j = 1; j < values.length; j++) {
            result = Math.max(result, maxSoFar + values[j] - j); 
            maxSoFar = Math.max(maxSoFar, values[j] + j);
        }

        return result;
    }
}
