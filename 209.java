class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        int len = nums.length;
        int left = 0;
        int sum = 0;
        int ans = len+1;
        // 从左往右遍历right
        for(int right = 0;right<len;right++){
            sum+=nums[right];
            // 先向右累加，如果突然变大了，那么就从左往右开始缩小，并且更新结果
            while(sum>=target){
                ans=Math.min(ans,right-left+1);
                // 从左往右缩小，并且更新指针
                sum-=nums[left];
                left++;
            }
        }
        if(ans<=len){
            return ans;
        }
        return 0;

    }
}

// 第二次做的做法
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum =0;
        int length = 0;
        for(int right = 0;right<nums.length;right++){
            sum+=nums[right];
            length++;
            
            while(sum>=target){
                ans = Math.min(ans,length);
                sum-=nums[left];
                left++;
                length--;
            }
        }
        if(ans==Integer.MAX_VALUE)
            return 0;
        return ans;
    }
}