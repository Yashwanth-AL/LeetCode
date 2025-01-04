class Solution {
    public int maxScore(String s) {
        int total_1 = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') total_1++;
        }

        int maxScore = 0;
        int zeroes = 0;
        int ones = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '0') {
                zeroes++;
            } else {
                ones++;
            }
            int currentScore = zeroes + total_1 - ones;
            maxScore = Math.max(currentScore, maxScore);
        }
        return maxScore;
    }
}
