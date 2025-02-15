class Solution {
    private static int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenChoices = power(5, evenPositions);
        long oddChoices = power(4, oddPositions);

        return (int) ((evenChoices * oddChoices) % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;
        while(exp > 0) {
            if((exp & 1) == 1) { //check if it is odd
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
