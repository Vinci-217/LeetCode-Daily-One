class Solution {

    int[] nums;
    int[][] memo;
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        this.nums = nums;
        memo = new int[n][2];
        for(int[] row : memo) Arrays.fill(row,-1);
        return dfs(n-1,0);
    }


    private int dfs(int i,int flag){
        if(i==0&&flag!=1)
            return nums[0];
        else if(i==0&&flag!=0)
            return 0;
        else if(i<0)
            return 0;

        if(memo[i][flag]!=-1) return memo[i][flag] ;

        int n1 = dfs(i-1,flag);
        if(i==n-1) flag = 1;
        int n2 = dfs(i-2,flag)+nums[i];
        if(n1>n2){
            return memo[i][flag] = n1;
        }
        else{
            return memo[i][flag] = n2;
        }
    }
}