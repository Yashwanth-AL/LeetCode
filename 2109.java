class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder modified = new StringBuilder();
        int previous = 0;
        for(int i = 0; i < spaces.length; i++){
            modified.append(s.substring(previous, spaces[i]));
            modified.append(" ");
            previous = spaces[i];
        }
        modified.append(s.substring(previous));
        return modified.toString();
    }
}
