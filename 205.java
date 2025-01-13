class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if (map.containsKey(s1)) {
                if (map.get(s1) != t1) return false;
            } else if (map.containsValue(t1)) {
                return false;
            } else {
                map.put(s1, t1);
            }
        }

        return true;
    }
}
