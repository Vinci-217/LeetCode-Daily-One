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

// 第二次递归做法，统一写法
class Solution {
    private int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return dfs(n);
    }

    private int dfs(int length){
        if(length<=0){
            return 0;
        }
        if(length==1){
            return 1;
        }
        if(length==2){
            return 2;
        }
        if(memo[length]!=-1){
            return memo[length];
        }
        return memo[length] = dfs(length-1)+dfs(length-2);
    }

}