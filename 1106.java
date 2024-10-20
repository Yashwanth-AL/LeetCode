class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();

        for(char ch : expression.toCharArray()){
            if(ch == '(' || ch == ','){
                continue;
            } else if (ch == '!' || ch == '&' || ch == '|' || ch == 'f' || ch == 't'){
                stack.push(ch);
            } else if (ch == ')') {
                Stack<Character> temp = new Stack<>();
                while(stack.peek() != '&' && stack.peek() != '!' && stack.peek() != '|'){
                    temp.push(stack.pop());
                }
                char operator = stack.pop();
                stack.push(evaluate(operator, temp));
            }
        }

        return stack.pop() == 't';
    }

    public char evaluate(char operator, Stack<Character> temp){
        if(operator == '!'){
            return temp.pop() == 't' ? 'f' : 't';
        }else if(operator == '&'){
            while(!temp.isEmpty()){
                if(temp.pop() == 'f'){
                    return 'f';
                }
            }
            return 't';
        }else if (operator == '|'){
            while(!temp.isEmpty()){
                if(temp.pop() == 't'){
                    return 't';
                }
            }
            return 'f';
        }
        return 'f';
    }
}
