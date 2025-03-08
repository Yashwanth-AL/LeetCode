class Solution {
    public int minimumRecolors(String blocks, int k) {
        int current = 0;

        for(int i = 0; i < k ; i++) {
            if(blocks.charAt(i) == 'W') {
                current++;
            }
        }

        int min = current;
        for(int i = k; i < blocks.length(); i++) {
            if(blocks.charAt(i - k) == 'W') {
                current--;
            }
            if(blocks.charAt(i) == 'W') {
                current++;
            }
            min = Math.min(min, current);
        }
        return min;
    }
}
