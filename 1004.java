class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int cn0 = 0;
        int ans = 0;
        for(int right = 0;right<nums.length;right++){
            cn0+=1-nums[right]; // 将0变成1，用来统计0的次数
            while(cn0>k){
                cn0 = cn0-(1-nums[left++]);
            }
            ans=Math.max(ans,right-left+1);
        } 
        return ans;
    }
}