class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getMax(int[] piles) {
        int max = piles[0];
        for(int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }

    public boolean canFinish(int piles[], int h, int mid) {
        int hours = 0;
        for(int pile : piles) {
            hours += (pile + mid - 1) / mid;
        }
        return hours <= h;
    }
}
