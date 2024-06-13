class Solution {
    public long countSubarrays(int[] nums, int k) {
        long max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        long ans = 0;
        int left = 0;
        long cntMax = 0;
        for(int right = 0;right<nums.length;right++){

            // right一直向右遍历，如果遇到相等的就让计数器加一。
            if(nums[right]==max){
                cntMax++;
            }
            // 如果计数器达到了k，那就让left++，然后结果加left（表示左边全部都成立）
            while(cntMax==k){
                if(nums[left++]==max){
                    cntMax--;
                }
            }
            ans+=left;
        }
        return ans;

    }
}