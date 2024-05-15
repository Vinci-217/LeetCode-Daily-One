class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer,Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0,1);

        int preSum=0;
        int count= 0;
        for(int num:nums){
            preSum+=num;

            // 这里格外要注意，这里的思想相当于前缀差分以后等于k的都加上了，而不是直接count++，这样不仅更高效，最重要的是不会影响差分不为k的部分
            // 也就是说，我现在遇到一个前缀和为a，我可以所有的b，使得a-b=k的b都拿出来，然后差分。为什么会存在这种可能呢，因为可能有负数，导致我的b再次出现了
            if(preSumFreq.containsKey(preSum-k)){
                count+=preSumFreq.get(preSum-k);
            }

            preSumFreq.put(preSum,preSumFreq.getOrDefault(preSum,0)+1);
        }

        return count;

    }
}