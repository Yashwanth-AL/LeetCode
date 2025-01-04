class Solution {
    public int countPalindromicSubsequence(String s) {
        int first[] = new int[26];
        int last[] = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        int totalCount = 0;

        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(first[index] == -1) {
                first[index] = i;
            } 
            last[index] = i;
        }

        for(int j = 0; j < 26; j++) {
            int start = first[j];
            int end = last[j];

            if(start != -1 && end != -1 && start < end) {
                HashSet<Character> set = new HashSet<>();
                for(int k = start + 1; k < end; k++) {
                    set.add(s.charAt(k));
                }
                totalCount += set.size();
            }
        }

        return totalCount;

    }
}
