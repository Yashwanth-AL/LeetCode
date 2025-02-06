class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0; 

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); 
        }

        int maxLength = 0;

        for (int num : set) { 
            if (!set.contains(num - 1)) { 
                int current = num;
                int streak = 1;

                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }

                maxLength = Math.max(maxLength, streak);
            }
        }
        return maxLength;
    }
}
