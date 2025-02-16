class Solution {

    private static final String[] keypad = {
         "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" 
    };
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
       if(digits.isEmpty()) return result;
       backTrack(digits, 0, new StringBuilder());
       return result;
    }

    public void backTrack(String digits, int index, StringBuilder s) {
        if(index == digits.length()) {
            result.add(s.toString());
            return;
        }

        String letters = keypad[digits.charAt(index) - '0'];
        for(char ch : letters.toCharArray()) {
            s.append(ch);
            backTrack(digits, index + 1, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
