class Solution {
    public boolean lemonadeChange(int[] bills) {
        int arr[] = new int[2];

        for(int bill : bills) {
            if(bill == 5) {
                arr[0]++;
            } else if(bill == 10) {
                arr[1]++;
                if(arr[0] > 0) {
                    arr[0]--;
                } else {
                    return false;
                }
            } else {
                if(arr[0] > 0 && arr[1] > 0) {
                    arr[0]--;
                    arr[1]--;
                } else if (arr[0] >= 3) {
                    arr[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
