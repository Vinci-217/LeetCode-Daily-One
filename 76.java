class Solution {
    public String minWindow(String S, String t) {


        // 将是否包含，转化为出现次数，从而统计频率
        // 对于包含的比较，只需要比较出现次数即可
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int left = 0;
        int[] cntS = new int[128]; // 用来统计s子串中每个字母的出现次数
        int[] cntT = new int[128]; // 用来统计t中每个字母的出现次数
        // 遍历t，统计每个字母出现的频率
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }
        // 遍历s，right每次加入到频率中，并且每次比较是否包含，如果包含就更新左右节点，并且让左指针右移
        for (int right = 0; right < m; right++) {
            cntS[s[right]]++;
            // 左端点右移的条件，在于判断是否包含
            while (isCovered(cntS, cntT)) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[s[left++]]--;
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;

    }
}