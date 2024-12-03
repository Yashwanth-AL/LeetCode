class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0; // Tracks the current index in spaces array
        
        for (int i = 0; i < s.length(); i++) {
            // If the current index matches a value in spaces, insert a space
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                result.append(" ");
                spaceIndex++; // Move to the next index in spaces
            }
            result.append(s.charAt(i)); // Append the current character
        }
        
        return result.toString();
    }
}
