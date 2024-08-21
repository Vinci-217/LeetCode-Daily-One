class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        dp[2] = nums[1];
        for (int i = 3; i <= nums.length; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-3]+nums[i-1]);
        }
        return Math.max(dp[nums.length],dp[nums.length-1]);
    }
}

// class Solution {
//     private int[] nums,memo;
//     public int rob(int[] nums) {
//         this.nums = nums;
//         int n = nums.length;
//         memo = new int[n];
//         Arrays.fill(memo,-1);
//         return dfs(n-1);
//     }
//     private int dfs(int i){
//         if(i<0)
//             return 0;
//         if(memo[i]!=-1){
//             return memo[i];
//         }
//         int ans = Math.max(dfs(i-1),dfs(i-2)+nums[i]);
//         memo[i]=ans;
//         return ans;
//     }
// }