import java.util.*;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long left = 1, right = (long) ranks[0] * (long) cars * cars; 

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairInTime(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canRepairInTime(int[] ranks, int cars, long time) {
        long totalCarsRepaired = 0;
        for (int rank : ranks) {
            totalCarsRepaired += (long) Math.sqrt(time / (double) rank);
            if (totalCarsRepaired >= cars) return true;
        }
        return false;
    }
}
