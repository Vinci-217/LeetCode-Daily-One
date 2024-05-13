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