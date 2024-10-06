class Solution {
    public int trap(int[] height) {
        int l = height.length;

        int left[] = new int[l];
        left[0] = height[0];
        for(int i = 1; i < l; i++){
            left[i] = Math.max(height[i], left[i-1]);
        }

        int right[] = new int[l];
        right[l-1] = height[l-1];
        for(int i = l-2; i >= 0; i--){
            right[i] = Math.max(height[i], right[i+1]);
        }

        int sum = 0;
        for(int i = 0; i < l; i++){
            int res = Math.min(left[i], right[i]) - height[i];
            sum += res < 0 ? 0 : res;
        }
        return sum;
    }
}

// Optimised version
// class Solution {
//     public int trap(int[] height) {

//         int left = 0, right = height.length - 1;
//         int leftMax = 0, rightMax = 0;
//         int totalWater = 0;

//         while (left <= right) {
//             if (height[left] <= height[right]) {
//                 if (height[left] >= leftMax) {
//                     leftMax = height[left];
//                 } else {
//                     totalWater += leftMax - height[left];
//                 }
//                 left++;
//             } else {
//                 if (height[right] >= rightMax) {
//                     rightMax = height[right];
//                 } else {
//                     totalWater += rightMax - height[right];
//                 }
//                 right--;
//             }
//         }

//         return totalWater;
//     }
// }
