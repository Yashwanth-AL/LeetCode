class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftEffect = new int[n + 1]; 
        
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            shiftEffect[start] += direction == 1 ? 1 : -1;
            shiftEffect[end + 1] += direction == 1 ? -1 : 1;
        }
        
        int cumulativeShift = 0;
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            cumulativeShift += shiftEffect[i];
            int netShift = (cumulativeShift % 26 + 26) % 26; 
            char current = result.charAt(i);
            current = (char) ((current - 'a' + netShift) % 26 + 'a');
            result.setCharAt(i, current);
        }
        
        return result.toString();
    }
}
