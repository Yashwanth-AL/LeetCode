class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        
        int m = word1.length();
        int n = word2.length();
        int min = Math.min(m,n);

        for(int i = 0; i < min; i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if(m > n){
            sb.append(word1.substring(min));
        } else{
            sb.append(word2.substring(min));
        }
        return sb.toString();
    }
}
