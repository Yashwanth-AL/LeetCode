class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            int current = (start >> i) & 1;
            int target = (goal >> i) & 1;
            if((current ^ target) != 0) {
                count++;
            }
        }
        return count;
    }
}
