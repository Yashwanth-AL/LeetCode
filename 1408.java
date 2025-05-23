class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && words[j].contains(words[i])) {
                    set.add(words[i]);
                    break;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
