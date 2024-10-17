class Solution {
    public int maximumSwap(int num) {
       char number[] = String.valueOf(num).toCharArray();
       for(int i = 0; i < number.length; i++){
            int big = i;
            for(int j = i+1; j < number.length; j++){
                if(number[j] >= number[big]){
                    big = j;
                }
            }
            if(big != i && number[big] != number[i]){
                char temp = number[i];
                number[i] = number[big];
                number[big] = temp;
                return Integer.parseInt(new String(number));
            }
        }
        return num;
    }
}
