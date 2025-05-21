class Solution {
    public boolean areOccurrencesEqual(String s) {
        int arr[] = new int[26];
        for(char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int count = arr[s.charAt(0) - 'a'];
        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0 && arr[i] != count) {
                return false;
            }
        }
        return true;
    }
}
