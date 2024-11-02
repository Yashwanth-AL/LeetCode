class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] str = sentence.split("\\s+");
        char first = str[0].charAt(0);
        int length = str.length;
        for(int i = 0; i < length - 1; i++){
            if(str[i].charAt(str[i].length() - 1) != str[i+1].charAt(0)){
                return false;
            }
        }
        return str[length - 1].charAt(str[length - 1].length() - 1) == first;
    }
}
