class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                char popped = stack.pop();
                if((ch == ')' && popped != '(') ||
                   (ch == '}' && popped != '{') ||
                   (ch == ']' && popped != '[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
