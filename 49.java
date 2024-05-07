class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 方法1
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(String str:strs){
            //先取出来，排序，然后再放进去
            char[] array =str.toCharArray();
            Arrays.sort(array);
            String key =new String(array);

            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());

        // // 方法2
        // Map<String,List<String>> map=new HashMap<String,List<String>>();
        // for(String str:strs){
        //     int[] counts =new int[26];
        //     int length =str.length();
        //     for(int i=0;i<length;i++){
        //         counts[str.charAt(i)-'a']++;
        //     }
        //     StringBuffer sb=new StringBuffer();
        //     for(int i=0;i<26;i++){
        //         if(counts[i]!=0){
        //             sb.append((char)('a'+i));
        //             sb.append(counts[i]);
        //         }
        //     }
        //     String key =sb.toString();
        //     List<String> list= map.getOrDefault(key,new ArrayList<String>());
        //     list.add(str);
        //     map.put(key,list);
        // }
        // return new ArrayList<List<String>>(map.values());
    }
}