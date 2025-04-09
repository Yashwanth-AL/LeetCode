public class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Use long to avoid overflow during abs
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        // Subtract the largest possible multiple of divisor from dividend
        while (a >= b) {
            long temp = b;
            int multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        // Determine the sign
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }
}
