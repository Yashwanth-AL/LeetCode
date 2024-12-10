import java.util.*;

class Solution {
    public int maximumLength(String s) {

        int n = s.length();
        int maxLength = 0;

        for (int l = 1; l <= n; l++) {
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i <= n - l; i++) {
                String sub = s.substring(i, i + l);

                if (isSpecial(sub)) {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);

                    if (map.get(sub) >= 3) {
                        maxLength = Math.max(maxLength, l);
                    }
                }
            }
        }

        return maxLength == 0 ? -1 : maxLength;
    }

    private boolean isSpecial(String sub) {
        char firstChar = sub.charAt(0);
        for (char c : sub.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }
}
