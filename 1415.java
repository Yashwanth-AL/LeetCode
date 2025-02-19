class Solution {

    char ch[] = new char[]{'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        backTrack(n, new StringBuilder(), list);
        if(list.size() >= k) {
            return list.get(k - 1);
        }
        return "";
    }

    public void backTrack(int n, StringBuilder s, List<String> list) {
        if(s.length() == n) {
            list.add(s.toString());
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(s.length() > 0 && s.charAt(s.length() - 1) == ch[i]){
                continue;
            }
            s.append(ch[i]);
            backTrack(n, s, list);
            s.deleteCharAt(s.length() - 1);
        }

    }
}
