class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(left <= right){
            int min = Math.min(height[left], height[right]);
            int area = min * (right - left);
            if(area > maxArea){
                maxArea = area;
            }
            if(height[left] == min){
                left++; 
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
