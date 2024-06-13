class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int left = 0;
        long cnt = 0;
        for(int right = 0;right<nums.length;right++){
            cnt+=nums[right];
            while(cnt*(right-left+1)>=k){
                cnt-=nums[left];
                left++;
            }
            ans+=right-left+1;
        }
        return ans;
    }
}