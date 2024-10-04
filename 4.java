class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int m = nums1.length; 
        int n = nums2.length;
        int len = m + n;
        int arr[] = new int[len];
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while(i < m){
            arr[k++] = nums1[i++];
        } 
        while(j < n){
            arr[k++] = nums2[j++];
        }
        if(len % 2 != 0){
            return arr[len / 2];
        } else {
            double value = arr[len / 2] + arr[(len / 2) - 1];
            return value / 2;
        }
    }
}
