class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return gcd(max, min);
    }

    public int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
