class Solution {
    public int longestSquareStreak(int[] nums) {

        Set<Long> set = new HashSet<>();

        for (int num : nums) {
            set.add((long)num);
        }
        
        int max = -1;
        for(int num : nums) {
            int count = 1;
            long n = num;
            while(set.contains(n * n)) {
                n *= n;
                count++;
            }
            max = Math.max(max, count);
        }
        return max >= 2 ? max : -1;
    }
}
