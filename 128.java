class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int n :nums){
            set.add(n);
        }

        for(int i=0;i<nums.length;i++){
            int currentNum = 0;
            int currentLength = 0;
            // 判断何时为起点
            if(!set.contains(nums[i]-1)){
                currentNum=nums[i];
                currentLength=1;
                // 到起点了，可以开始循环一直找了
                while(set.contains(currentNum+1)){
                    currentNum ++;
                    currentLength++;
                }
                
                ans = Math.max(ans,currentLength);
            }


        }
        return ans;
    }
}