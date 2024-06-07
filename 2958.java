class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans =0;
        Map<Integer,Integer> fre = new HashMap<>();
        int left =0;
        for(int right = 0;right<nums.length;right++){
            fre.merge(nums[right], 1, Integer::sum);
            while(fre.get(nums[right])>k){
                fre.merge(nums[left++], -1, Integer::sum);
            }
            ans =Math.max(ans,right-left+1);
        }
        return ans;
    }
}