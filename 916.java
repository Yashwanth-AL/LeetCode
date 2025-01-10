class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] required = new int[26]; 

        for (String word : words2) {
            int[] temp = new int[26];
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                required[i] = Math.max(required[i], temp[i]);
            }
        }

        for (String word : words1) {
            if (isUniversal(word, required)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean isUniversal(String word, int[] required) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] < required[i]) {
                return false;
            }
        }
        return true;
    }
}
