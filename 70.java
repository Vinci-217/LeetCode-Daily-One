class Solution {
    public int climbStairs(int n) {
        int[] dp =new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

// class Solution {
//     private int[] memo;
//     public int climbStairs(int n) {
//         memo = new int[n+1];
//         Arrays.fill(memo,-1);
//         return dfs(n);
//     }

//     private int dfs(int i){
//         if(i<=1){
//             return 1;
//         }
//         if(memo[i]!=-1){
//             return memo[i];
//         }

//         return memo[i]=dfs(i-1)+dfs(i-2);
//     }
// }