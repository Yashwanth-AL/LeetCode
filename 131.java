class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0, new ArrayList<>());
        return result;
    }

    public void backTrack(String s, int index, List<String> list) {
        if(index == s.length()) {
            result.add(new ArrayList(list));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                backTrack(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
