class Solution {

    public int findKthPositive(int[] arr, int k) {
        for(int num : arr) {
            if(num <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }   


    // public int findKthPositive(int[] arr, int k) {
    //     List<Integer> list = new ArrayList<>();
    //     int previous = 1;

    //     for(int num : arr) {
    //         while(previous < num) {
    //             list.add(previous);
    //             previous++;
    //         }
    //         previous++;
    //         if(list.size() >= k) {
    //             return list.get(k - 1);
    //         }
    //     }
    //     int last = arr[arr.length - 1];
    //     return last + k - list.size();
    // }
}
