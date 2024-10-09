class Solution {
    public int minAddToMakeValid(String s) {
        int insertions = 0;
        int balancedFactor = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '('){
                balancedFactor++;
            }else {
                balancedFactor--;
            }
            if(balancedFactor < 0){
                insertions++;
                balancedFactor = 0;
            }
        }
        return balancedFactor + insertions;
    }
}
