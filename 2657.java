class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int result[] = new int[A.length];
        Set<Integer> set = new HashSet<>();

        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(set.contains(A[i])) {
                count++;
            } else {
                set.add(A[i]);
            }  

            if(set.contains(B[i])) {
                count++;
            } else {
                set.add(B[i]);
            }

            result[i] = count;
        }
        
        return result;
    }
}
