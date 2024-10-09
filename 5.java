class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }

        int start = 0; 
        int end = 0;

        for(int i = 0; i < s.length(); i++){

            int len1 = findLength(s, i, i); //odd length palindrome
            int len2 = findLength(s, i, i+1); //even palindrome length
            int max = Math.max(len1, len2);

            if(max > (end - start)){
                start = i - (max - 1) / 2; //move the cursor to the left of the i by x position
                end = i + (max / 2) + 1;
            }
        }
        return s.substring(start, end);
    }

    public static int findLength(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return (right - left) - 1;
    }
}
