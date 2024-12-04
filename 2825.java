class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        while(j < str2.length() && i < str1.length()){
            if (check(str1.charAt(i), str2.charAt(j))){
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == str2.length();
    }

    public boolean check(char i, char j){
        if(i == 'z' && j == 'a'){
            return true;
        }
        return i == j || (char)(i+1) == j;
    }
}
