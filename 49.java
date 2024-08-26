class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String str:strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            List<String> list = map.getOrDefault(new String(s),new ArrayList<>());
            list.add(str);
//            System.out.println(list);
            map.put(new String(s),list);
        }
        map.forEach((key,value)->{

            ans.add(value);
        });
        return ans;

    }
}