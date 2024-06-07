class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1)
            return 0;
        int n = nums.length;

        int left = 0;
        int ans = 0;
        int s = 1;

        // right是固定的，然后从左到右
        for (int right = 0; right < n; right++) {
            s = s * nums[right];
            while (s >= k) {
                s = s / nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;

    }
}