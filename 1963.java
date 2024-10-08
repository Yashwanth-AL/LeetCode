class Solution {
    public int minSwaps(String s) {
        int balanced = 0;
        int imbalance = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '['){
                balanced++;
            }else {
                balanced--;
            }
            if(balanced < 0){
                imbalance++;
                balanced = 0;
            }
        }
        return (imbalance + 1) / 2;
    }
}
