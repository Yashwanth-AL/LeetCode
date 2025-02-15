class Solution {
    public int punishmentNumber(int n) {
        int result = 0;

        for(int i = 1; i <= n; i++) {
            if(isValid(i)) {
                result += (i * i);
            }
        }
        return result;
    }

    private boolean isValid(int num) {
        String square = String.valueOf(num * num);
        return canPartition(square, 0, 0, num);
    } 

    private boolean canPartition(String s, int index, int currentSum, int target) {
        if(index == s.length()) return currentSum == target;

        int num = 0;
        for(int i = index; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if(currentSum + num > target) break;
            if(canPartition(s, i + 1, num + currentSum, target)) {
                return true;
            }
        }
        return false;
    }
}
