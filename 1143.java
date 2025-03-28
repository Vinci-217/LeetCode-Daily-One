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

// 第二次做法
class Solution {
    char[] t1;
    char[] t2;
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        t1 = text1.toCharArray();
        t2 = text2.toCharArray();
        memo = new int[t1.length][t2.length];
        for(int[] row : memo) Arrays.fill(row,-1);
        return dfs(t1.length-1,t2.length-1);
    }

    private int dfs(int i,int j){
        if(i<0||j<0) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(t1[i] == t2[j]) return memo[i][j] = dfs(i-1,j-1)+1;
        return memo[i][j] = Math.max(dfs(i-1,j),dfs(i,j-1));
    }
}