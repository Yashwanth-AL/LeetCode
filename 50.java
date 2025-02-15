class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;

        if(n < 0) {
            x = 1 / x;
            return (n == Integer.MIN_VALUE) ? x * myPow(x, Integer.MAX_VALUE) : myPow(x, -n);
        }

        double half = myPow(x, n / 2);

        if(n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
