class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 != 0) return false;

        int openCount = 0;
        int closedCount = 0;
        int wildCards = 0;

        for(int i = 0; i < n; i++) {
            if(locked.charAt(i) == '1') {
                if(s.charAt(i) == '(') {
                    openCount++;
                } else {
                    openCount--;
                }
            } else {
                wildCards++;
            } 

            if(openCount + wildCards < 0){
                return false;
            }
        }

        wildCards = 0;
        
        for(int i = n-1; i >= 0; i--) {
            if(locked.charAt(i) == '1') {
                if(s.charAt(i) == ')') {
                    closedCount++;
                } else {
                    closedCount--;
                }
            } else {
                wildCards++;
            } 

            if(closedCount + wildCards < 0){
                return false;
            }
        }

        return true;
    }
}
