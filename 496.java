class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums2.length;
        for(int i = 0; i < n; i++) {
            int key = nums2[i];
            int value = -1;
            for(int j = i + 1; j < n; j++) {
                if(nums2[j] > key) {
                    value = nums2[j];
                    break;
                }
            }   
            map.put(key, value);
        }

        int result[] = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
