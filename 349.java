class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }

        Set<Integer> common = new HashSet<>();
        for(int num : nums2) {
            if(set.contains(num)){
                common.add(num);
            }
        }

        int arr[] = new int[common.size()];
        int index = 0;
        for(int num : common) {
            arr[index++] = num;
        }
        return arr;
    }
}
