class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            int cnt = map.getOrDefault(num,0);
            cnt++;
            map.put(num,cnt);
        }
        List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
        Collections.reverse(sortedList);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<k;i++){
            ans.add(sortedList.get(i).getKey());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}