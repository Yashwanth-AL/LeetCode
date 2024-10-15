class Solution {
    public long minimumSteps(String s) {
        char c[] = s.toCharArray();
        long swaps = 0;
        long count_one = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] == '1'){
                count_one++;
            } else {
                swaps += count_one;
            }
        }
        return swaps;
    }
}
