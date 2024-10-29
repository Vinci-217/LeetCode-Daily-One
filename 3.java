class Solution {
    public int lengthOfLongestSubstring(String s) {

        // // 双指针解法
        // Set<Character> set = new HashSet<>();
        // int length = 0;
        // for (int i = 0; i < s.length(); i++) {

        //     int currentI = i;
        //     int currentlength = 0;
        //     char a = s.charAt(i);

        //     while (set.add(a)) {
        //         currentI++;
        //         currentlength++;
        //         if(currentI==s.length()){
        //             break;
        //         }
                
        //         a = s.charAt(currentI);
        //     }

        //     set.clear();

        //     length = Math.max(length, currentlength);

        // }
        // return length;

        if(s.length()==0)
            return 0;
        HashMap<Character,Integer> map =new HashMap<Character,Integer>();
        int max=0;
        int left =0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }

}

// 第二次重做双指针做法
class Solution {
    /**
        标准的滑动窗口的题目
        滑动窗口的实现方法之一是双指针，在这里双指针是一个指针不动，另一个一直从左往右
        在右指针遍历的过程中，用while循环检验右指针指向的位置是否在已知集合中
        如果在已知集合中，那么就需要左指针已知右移，并且弹出原有指针指向元素
        如果不在已知集合中，那么就将右指针元素加入到已知集合中
     */
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int left = 0;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(int right=0;right<n;right++){
            char c = s[right];
            while(set.contains(c)){
                set.remove(s[left]);
                left++;
            }
            set.add(c);
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}


// 第三次重做做法，半小时做出来的

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        int left = 0;
        int right = left;
        Map<Character,Integer> map = new HashMap<>();
        while(right<n){
            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),1);
                right++;
                continue;
            }
            if(map.containsKey(s.charAt(right))){
                ans = Math.max(ans,right-left);
                while(map.containsKey(s.charAt(right))){
                    map.remove(s.charAt(left));
                    left++;
                }
                map.put(s.charAt(right),1);
                right++;
            }
        }
        ans = Math.max(ans,right-left);
        return ans;
    }
}