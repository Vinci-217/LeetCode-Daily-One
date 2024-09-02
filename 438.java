class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        // 初始化一个数组，用来统计字符串 p 中每个字符的出现次数
        int[] cnt = new int[26];

        for(int i=0;i<p.length();i++){
            cnt[p.charAt(i)-'a']++;
        }

        // l和r分别表示滑动窗口的左右边界
        int l=0;
        for(int r=0;r<s.length();r++){
            // 更新当前滑动窗口中的计数数组
            cnt[s.charAt(r)-'a']--;
            // 从左侧收缩窗口，直到 当前字符的计数在限定范围内
            while(cnt[s.charAt(r)-'a']<0){
                cnt[s.charAt(l)-'a']++;
                l++;
            }

            // 检查当前窗口的大小是否等于字符串p的大小
            if(r-l+1==p.length()){
                ans.add(l);
            }
        }

        return ans;

    }
}

// 第二次的做法

class Solution {
    public List<Integer> findAnagrams(String S, String p) {
        int left = 0;
        char[] s = S.toCharArray();
        int n = s.length;
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();
        if(s.length<p.length()){
            return List.of();
        }
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < p.length(); i++) {
            char c = s[i];
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
        }
        if (windowCount.equals(pCount)) {
            ans.add(left);
        }
        for (int right = p.length(); right < n; right++) {

            windowCount.put(s[right], windowCount.getOrDefault(s[right], 0) + 1);
            if (windowCount.get(s[left]) == 1) {
                windowCount.remove(s[left]);
            } else {
                windowCount.put(s[left], windowCount.get(s[left]) - 1);
            }
            left++;
            if (windowCount.equals(pCount)) {
                ans.add(left);
            }
            
            System.out.println("left=" + left + s[left]);
            System.out.println("right=" + right + s[right]);
        }
        return ans;
    }
}