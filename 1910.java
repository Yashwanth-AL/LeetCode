class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder result = new StringBuilder(s);
        int length = part.length();
        int index;

        while((index = result.indexOf(part)) != -1) {
            result.delete(index, index + length);
        } 

        return result.toString();
    }
}
