class Solution {
    private char[] s, t;
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        s = text1.toCharArray();
        t = text2.toCharArray();

        int n = s.length;
        int m = t.length;
        memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(n - 1, m - 1);
    }

    private int dfs(int i,int j){
        if(i<0||j<0){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s[i] == t[j]){
            return memo[i][j] = dfs(i-1,j-1)+1;
        }
        return memo[i][j] = Math.max(dfs(i-1,j),dfs(i,j-1));
    }
}