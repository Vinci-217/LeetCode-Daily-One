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

// 第二次做：
// 注意ans更新和minSum更新的顺序
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int preSum = 0;
        int minSum = 0;
        for(int n :nums){
            preSum = preSum+n;
            ans = Math.max(preSum-minSum,ans);
            minSum = Math.min(minSum,preSum);
        }
        return ans;

    }
}