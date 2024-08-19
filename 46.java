class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        dfs(0, set);
        return ans;
    }

    private void dfs(int i, Set<Integer> set) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (Integer j : set) {
            path.add(j);
            Set<Integer> t = new HashSet<>(set);
            t.remove(j);
            dfs(i + 1, t);
            path.remove(j);
        }
    }
}