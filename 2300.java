class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int ans = 0;
        for (int i = 0; i < spells.length; i++) {
            long target = (success -1) / spells[i]; // 1.
            if (target < potions[potions.length - 1]) { 
                spells[i] = potions.length - lowerBound(potions, (int) target);
            } else {
                spells[i] = 0;
            }
        }
        return spells;
    }

    // 函数的作用是返回第一个大于等于target的下标
    private int lowerBound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) { //2.
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}