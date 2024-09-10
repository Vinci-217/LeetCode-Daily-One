class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int preSum = 0;
        int minPreSum = 0;
        for(int x:nums){
            preSum +=x;
            ans = Math.max(ans,preSum-minPreSum);
            minPreSum = Math.min(minPreSum,preSum);
        }
        return ans;

    }
}