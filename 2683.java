class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int sum = 0;

        for(int num : derived) {
            sum ^= num;
        }

        return sum == 0;
    }
}
