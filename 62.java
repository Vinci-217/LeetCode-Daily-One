class Solution {
    int[][] memo = new int[101][101];
    public int uniquePaths(int m, int n) {
        for(int[] row : memo) Arrays.fill(row,-1);
        return dfs(m-1,n-1);
    }

    private int dfs(int i,int j){
        if(i<0||j<0) return 0;
        if(i==0&&j==0) return 1;
        if(memo[i][j]!=-1) return memo[i][j];
        return memo[i][j] = dfs(i-1,j)+dfs(i,j-1);
    }
}