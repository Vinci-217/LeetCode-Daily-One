class Solution {
    private char[] path;
    private final List<String> ans = new ArrayList<>();

    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2]; // 所有括号长度都是一样的 n*2
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int num) {
        if (i == n * 2) {
            ans.add(new String(path));
            return;
        }

        // 选左括号
        if (num < n) {
            path[i]='(';
            dfs(i + 1, num + 1);
        }

        // 选右括号
        if (i - num < num) {
            path[i]=')';
            dfs(i + 1, num);
        }
    }
}