class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int num:nums){
            num_set.add(num);
        }
        int result = 0;        
        for(int num:nums){
            if(!num_set.contains(num-1)){
                int currentLength = 1;
                int currentNum = num;

                while(num_set.contains(currentNum+1)){
                    currentLength++;
                    currentNum++;

                }
                result = Math.max(currentLength,result);
            }
        }
        return result;
    }
}