class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int[] nums;
    private Map<Integer,Integer> map = new HashMap<>();
    private int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        this.target = target;
        dfs(0,0);
        return ans;
    }

    private void dfs(int sum,int length){
        if(sum>target){
            return;
        }
        if(sum==target){
            ans.add(new ArrayList<>(path));
        }
        for(int i = length;i<nums.length;i++){
            path.add(nums[i]);
            sum+=nums[i];
            dfs(sum,i);
            sum-=nums[i];
            path.remove(path.size()-1);
        }
    }
}