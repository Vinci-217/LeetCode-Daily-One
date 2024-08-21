class Solution {
    private int[] nums,memo;
    private int ans;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new int[target + 1];
        this.nums = nums;
        Arrays.fill(memo, -1); // -1 表示没有计算过
        
        return dfs(target);
    }

    private int dfs(int i){
        if(i==0){
            return 1;
        }
        if (memo[i] != -1) { // 之前计算过
            return memo[i];
        }
        int res = 0;
        for(int j = 0;j<nums.length;j++){
            if(nums[j]<=i)
                res += dfs(i-nums[j]);
        }
        return memo[i]=res;
    }
}