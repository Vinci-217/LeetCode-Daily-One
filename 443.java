class Solution {
    public int compress(char[] nums) {
        if (nums.length == 1)
            return 1;
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < nums.length) {
            int cnt = 0;
            while (left < nums.length && right < nums.length && nums[right] == nums[left]) {
                cnt++;
                right++;
            }

            // 数字位置
            left++;
            if (left < nums.length && cnt > 1) {
                String str = Integer.toString(cnt);
                System.out.println(str);
                for (int i = 0; i < str.length(); i++) {
                    nums[left] = str.charAt(i);
                    left++;
                }
            }

            // 下一个字符
            if (left < nums.length && right < nums.length)
                nums[left] = nums[right];
        }

        return left;
    }
}