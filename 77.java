class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(n);
        return ans;
    }
    private void dfs(int i){
        int d = k-path.size(); // 还需要选d个数
        if(d==0){
            ans.add(new ArrayList<>(path));
            return ;
        }
        for(int j = i;j >= d;j--){
            path.add(j);
            dfs(j-1);
            path.remove(path.size()-1);
        }
    }
}