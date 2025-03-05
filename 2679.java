class Solution {
    public long coloredCells(int n) {
        long sum = (long) Math.pow(n, 2) + (long) Math.pow(n - 1, 2);
        return sum;
    }
}
