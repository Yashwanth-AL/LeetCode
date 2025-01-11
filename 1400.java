class Solution {
    public boolean canConstruct(String s, int k) {

        int arr[] = new int[26];
        for(char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        
        int oddCharacters = 0;
        
        for(int i = 0; i < 26; i++) {
            if(arr[i] % 2 != 0) {
                oddCharacters++;
            }
        }

        if(k < oddCharacters) return false;
        if(k > s.length()) return false;
        return true;
    }
}
