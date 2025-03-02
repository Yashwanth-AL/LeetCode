class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;

        List<int[]> list = new ArrayList<>();

        while(i < m && j < n) {
            int key = nums1[i][0];
            int value = 0;
            if(nums1[i][0] == nums2[j][0]) {
                value = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if(nums1[i][0] < nums2[j][0]) {
                value = nums1[i][1];
                i++;
            } else {
                key = nums2[j][0];
                value = nums2[j][1];
                j++;
            }
            list.add(new int[] {key, value});
        }

        while(i < m) {
            list.add(new int[] {nums1[i][0], nums1[i][1]});
            i++;
        }

        while(j < n) {
            list.add(new int[] {nums2[j][0], nums2[j][1]});
            j++;
        }

        return list.toArray(new int[0][]);
    }
}
