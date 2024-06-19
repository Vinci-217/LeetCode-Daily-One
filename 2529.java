class Solution {
    public int maximumCount(int[] nums) {
        int neg = lowerBound(nums,0); 
        int pos = nums.length-lowerBound(nums,1);
        return Math.max(neg,pos);
        

    }
    // 找到第一个大于等于 target 的位置
    private int lowerBound(int[] nums,int target){
        int left = -1;
        int right = nums.length;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            }
            else{
                left=mid;
            }
        }
        return right;
    }
}