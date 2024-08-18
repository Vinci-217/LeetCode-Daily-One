class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(9, n);
        return ans;
    }

    private void dfs(int i, int t) {
        int d = k - path.size(); // 还需要选d个数
        if (t < 0 || t > (i * 2 - d + 1) * d / 2)
            return;
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, t - j);
            path.remove(path.size() - 1);
        }
    }
}