class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while(left<=right){
            ans = Math.max((right-left)*Math.min(height[right],height[left]),ans);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return ans;

    }
}