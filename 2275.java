class Solution {
    public int largestCombination(int[] candidates) {
        
        int bits[] = new int[32];
        for(int candidate : candidates){
            for(int i = 0; i < 32; i++){
                if((candidate & (1 << i)) != 0){
                    bits[i]++;
                }
            }
        }

        int max = 0;
        for(int bit : bits){
            max = Math.max(max, bit);
        }
        return max;
    }
}
