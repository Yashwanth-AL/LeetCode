class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitCount = Integer.bitCount(num2);
        int result = 0;

        for(int i = 31; i >= 0 && bitCount > 0; i--) {
            if((num1 & (1 << i)) != 0) {
                result |= (1 << i);
                bitCount--;
            }
        }

        for(int i = 0; i < 32 && bitCount > 0; i++) {
            if((result & (1 << i)) == 0){
                result |= (1 << i);
                bitCount--;
            }
        }
        return result;

    }
}
