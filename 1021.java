class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        char[] input = s.toCharArray();

        Stack<Character> primitive = new Stack<>();
        int last = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '(') {
                primitive.push('(');
            } else {
                primitive.pop();
            }
            if(primitive.isEmpty()) {
                result.append(s.substring(last + 1, i));
                last = i + 1;
            }
        }

        return result.toString();
    }
}
