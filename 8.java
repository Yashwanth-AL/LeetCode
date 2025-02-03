class Solution {
    public int myAtoi(String s) {

        s = s.trim();
        long result = 0;
        int sign = 1, i = 0, n = s.length();

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++; 
        }

        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + (s.charAt(i) - '0');

            if(sign * result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if(sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign * result);
    }
}
