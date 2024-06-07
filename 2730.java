class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int left = 0;
        int n =s.length();
        int ans = 1;
        int same = 0;
        // 由于right需要和right-1比较，所以right从1开始
        for(int right=1;right<n;right++){
            if(s.charAt(right)==s.charAt(right-1)&&++same>1){
                // 让left移动到上一次相等的位置，两个位置中后面的位置，并且重置same
                for(left++;s.charAt(left)!=s.charAt(left-1);left++);
                same=1;
            }
            // 这样最后left和right分别指向了字符串的首尾位置
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}