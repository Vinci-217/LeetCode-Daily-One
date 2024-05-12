class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;

        int left=1;
        int right = height.length-2;



        for (int i = 1; i < height.length - 1; i++) {

            if(height[left-1]-1<height[right+1]){
                max_left=Math.max(max_left,height[left-1]);
                int min =max_left;
                if(min>height[left]){
                    sum += min - height[left];
                }
                left++;
            }
            else{
                max_right=Math.max(max_right,height[right+1]);
                int min =max_right;
                if(min>height[right]){
                    sum += min - height[right];
                }
                right--;
            }

        }

        return sum;

    }
}