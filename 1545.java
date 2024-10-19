class Solution {
    public char findKthBit(int n, int k) {
        String previous = "0";
        for(int i = 2; i <= n; i++){
            String start = new String(previous);
            String inverted = inverse(previous);
            String reversed = reverse(inverted); 
            previous = start + "1" + reversed;
        }
        return previous.charAt(k-1);
    }

    public String reverse(String str){
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length / 2; i++){
            char temp = ch[i];
            ch[i] = ch[ch.length - i - 1];
            ch[ch.length - i - 1] = temp;
        }
        return new String(ch);
    }

    public String inverse(String str){
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '0'){
                ch[i] = '1';
            } else {
                ch[i] = '0';
            }
        }
        return new String(ch);
    }
}
