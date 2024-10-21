class Solution {
    public int maxUniqueSplit(String s) {
        return backTrack(s, 0, new HashSet<>());
    }

    public int backTrack(String s, int start, HashSet<String> set){
        if(start == s.length()){
            return set.size();
        }

        int max = 0;
        for(int i = start + 1; i <= s.length(); i++){
            String substring = s.substring(start, i);
            if(!set.contains(substring)){
                set.add(substring);
                max = Math.max(max, backTrack(s, i, set));
                set.remove(substring);
            }
        }
        return max;
    }
}
