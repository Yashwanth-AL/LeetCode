class Solution {
    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int result[] = new int[n];

        if(k == 0){
            return result;
        }
        
        int sum = 0;
        int start = 1, end = k;

        if(k < 0){
            k = -k;
            start = n-k;
            end = n-1;
        }

        for(int i = start; i <= end; i++){
            sum += code[i % n];
        }

        for(int i = 0; i < n; i++){
            result[i] = sum;
            sum -= code[start % n];
            start++;
            end++;
            sum += code[end % n];

        }

        return result;
    }
}
