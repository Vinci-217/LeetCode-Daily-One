class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int max = 0;
        for(int n:nums1){
            int num = map.getOrDefault(n,0);
            map.put(n,num+1);
            max = Math.max(max,n);
        }
        
        for(int n:nums2){
            int m = 1;
            while(n*k*m<=max){
                if(map.containsKey(n*k*m)){
                    ans+=map.get(n*k*m);
                }
                m++;
            }
        }
        return ans;
        
    }
}