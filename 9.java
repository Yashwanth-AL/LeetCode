class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        int temp = x;
        while(temp > 0){
            int rem = temp % 10;
            sum = (sum * 10) + rem;
            temp /= 10;
        }
        return sum == x;
    }
}
