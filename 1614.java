class Solution {
    public int maxDepth(String s) {
        int current = 0;
        int maxCount = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                current++;
            }
            else if(ch == ')'){
                current--;
            }
            maxCount = Math.max(current, maxCount);
        }
        return maxCount;
    }
}
