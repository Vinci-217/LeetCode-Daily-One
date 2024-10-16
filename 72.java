class Solution {
    char[] s,t;
    int[][] memo;
    public int minDistance(String word1, String word2) {
        s = word1.toCharArray();
        t = word2.toCharArray();
        int m = s.length;
        int n = t.length;
        memo = new int[m][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dfs(m-1,n-1);
    }

    private int dfs(int i,int j){
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s[i]==t[j]){
            return memo[i][j] = dfs(i-1,j-1);
        }
        return memo[i][j] = Math.min(Math.min(dfs(i-1,j),dfs(i,j-1)),dfs(i-1,j-1))+1;
    }
}