class Solution {
    private int[] cost;
    private int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        this.cost=cost;
        int n = cost.length;
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return dfs(n);
    }
    private int dfs(int i){
        if(i<=1)
            return 0;
        if(memo[i]!=-1){
            return memo[i];
        }
        return memo[i]=Math.min(dfs(i-1)+cost[i-1],dfs(i-2)+cost[i-2]);

    }
}