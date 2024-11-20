class Solution {
    public boolean canJump(int[] nums) {
        int k=0;
        if(nums.length==1)
            return true;
        for(int i=0;i<nums.length;i++){
            if(i>k)
                return false;
            k=Math.max(k,i+nums[i]);
        }
        return true;

    }
}

// 第二次做法，深刻理解贪心
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            if(i>max){
                return false;
            }
            max = Math.max(max,i+nums[i]);
        }
        return true;
    }
}