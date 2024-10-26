class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int[] nums = new int[arr.length];
        nums = arr.clone();
        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, rank);
                rank++;
            }
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
