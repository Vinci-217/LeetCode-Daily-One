class Solution {
    int[] nums ;
    int[][] memo = new int[1001][10001];
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = Arrays.stream(nums).sum();
        for(int[] row: memo) Arrays.fill(row,-1);
        if(sum%2!=0) return false;
        return dfs(nums.length-1,sum/2);
    }

    private boolean dfs(int i,int j){
        if(i<0) return j==0;
        if(j<0) return false;
        if(j==0) return true;
        if(memo[i][j]!=-1) return memo[i][j]==1;;
        memo[i][j] = (dfs(i-1,j) || dfs(i-1,j-nums[i]) )?1:0;
        return memo[i][j] == 1;
    }
}