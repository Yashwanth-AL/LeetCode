class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        //find the longest increasing prefix
        int left = 0;
        while(left < n-1 && arr[left] <= arr[left+1]){
            left++;
        }

        if(left == n-1){
            return 0;
        }

        //find the longest increasing suffix
        int right = n-1;
        while(right > 0 && arr[right-1] <= arr[right]){
            right--;
        }

        int result = Math.min(right, n - left - 1);

        int i = 0, j = right;
        while(i <= left){
            while(j < n && arr[i] > arr[j]){
                j++;
            }

            result = Math.min(result, j-i-1);
            i++;
        }
        return result;
    }
}
