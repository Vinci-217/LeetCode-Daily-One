class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int close = Integer.MAX_VALUE;
        int ans = 0;

        Arrays.sort(nums);

        // 经典的一个循环+双指针。类似于三数之和，只不过多了大小的比较。注意j和i的流程控制

        for (int k = 0; k < nums.length; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            
            while (i < j) {
                int s = nums[i] + nums[j] + nums[k];
                
                if (s == target) {
                    return s;
                }
                if (s > target) {
                    if (s - target < close) {
                        close=s-target;
                        ans = s;
                    }
                    j--;
                } else {
                    if (target - s < close) {
                        close = target - s;
                        ans = s;
                    }
                    i++;
                }

            }

        }
        return ans;

    }
}