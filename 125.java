class Solution {
    public boolean isPalindrome(String s) {
        String replaced = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = replaced.length() - 1;
        while(i <= j){
            if(replaced.charAt(i) == replaced.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
