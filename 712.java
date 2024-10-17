
class Solution {
    char[] s;
    char[] t;
    int[][] memo;
    int ans = 0;

    public int minimumDeleteSum(String word1, String word2) {
        s = word1.toCharArray();
        t = word2.toCharArray();
        int m = s.length;
        int n = t.length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(m - 1, n - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0) {
            int ans = 0;
            for (int k = 0; k <= j; k++) {
                ans += t[k];
            }
            return ans;
        }
        if (j < 0) {
            int ans = 0;
            for (int k = 0; k <= i; k++) {
                ans += s[k];
            }
            return ans;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s[i] == t[j]) {
            return memo[i][j] = dfs(i - 1, j - 1);
        }
        if ((dfs(i, j - 1) + t[j]) > (dfs(i - 1, j)+ s[i])) {
            return memo[i][j] = dfs(i - 1, j) + s[i];
        } else {
            return memo[i][j] = dfs(i, j - 1) + t[j];
        }
    }
}