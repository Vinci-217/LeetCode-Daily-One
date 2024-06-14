class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        int left = 0;
        int ans = -1;
        int s = 0;
        // 求和
        for(int i=0;i<nums.length;i++){
            target+=nums[i];
        }
        // 求和仍然小于x
        if(target<0)
            return -1;
        int sum =0;
        // 爱来自灵茶山艾府 采用逆向思维，转换成找到一个最长子数组，元素和为s-x
        for(int right = 0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left++];
            }
            if(sum==target){
                ans=Math.max(ans,right-left+1);
            }
        }
        return ans<0?-1:nums.length-ans;
    }
}