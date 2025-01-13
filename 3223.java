public class Solution {
    public int minimumLength(String s) {

        int freq[] = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] > 2) {
                freq[i] = (freq[i] % 2 == 0) ? 2 : 1;
            }
        }

        int result = 0;
        for(int count : freq) {
            result += count;
        }
        return result;
    }
}
