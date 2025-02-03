class Solution {

    public int beautySum(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            int freq[] = new int[26];

            for(int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                result += findBeauty(freq);
            }
        }
        return result;
    }

    private int findBeauty(int arr[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int count : arr) {
            if(count > 0) {
                max = Math.max(max, count);
                min = Math.min(min, count);
            }
        }
        return max - min;
    }
}
