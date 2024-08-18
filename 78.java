class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
        int n = nums.length;
        dfs(0,n,nums);
        return ans;
    }
    private void dfs(int i,int n,int[] nums){
        if(i==n){
            ans.add(new ArrayList<>(path));
            return;
        }
        // System.out.println(nums[i]);
        // 没它
        dfs(i+1,n,nums);
        // 有它
        path.add(nums[i]);
        dfs(i+1,n,nums);
        path.remove(path.size()-1);
    }
}