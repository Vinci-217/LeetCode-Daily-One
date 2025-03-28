class Solution {

    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int score, int length) {
        if (score < 0 || score > n || length > n*2)
            return;
        if (score == 0 && length == n * 2) {
            ans.add(path.toString());
            return;
        }
        
        path.append('(');
        dfs(score + 1, length + 1);
        path.deleteCharAt(path.length() - 1);


        path.append(')');
        // System.out.println(path);
        dfs(score - 1, length + 1);
        path.deleteCharAt(path.length() - 1);
    }
}