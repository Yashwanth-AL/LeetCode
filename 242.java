class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
           count[ch-'a']++;
        }
         for(char ch : t.toCharArray()){
           count[ch-'a']--;
        }
        for(int val : count){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}

// this method uses sorting technique which is of more time complexity

// public boolean isAnagram(String s, String t) {
//     if(s.length() != t.length()){
//         return false;
//     }
//     char first[] = s.toCharArray();
//     char second[] = t.toCharArray();
//     Arrays.sort(first);
//     Arrays.sort(second);
    
//     return Arrays.equals(first, second);
// }
