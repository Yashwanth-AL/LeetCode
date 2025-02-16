class Solution {
    public int[] constructDistancedSequence(int n) {
        int length = 2 * n - 1;
        int result[] = new int[length];
        boolean used[] = new boolean[n + 1];
        backTrack(result, used, 0, n);
        return result;
    }

    private boolean backTrack(int[] result, boolean[] used, int index, int n) {
        if(index == result.length) return true;

        if(result[index] != 0) return backTrack(result, used, index + 1, n);

        for(int num = n; num >= 1; num--) {
            if(used[num]) continue;
            int nextIndex = (num == 1) ? index : index + num;
            
            if(nextIndex < result.length && result[nextIndex] == 0) {
                result[index] = result[nextIndex] = num;
                used[num] = true;

                if(backTrack(result, used, index + 1, n)) return true;

                result[index] = result[nextIndex] = 0;
                used[num] = false;
            }
        }
        return false;
    }
}
