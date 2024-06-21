class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        // 计数题排序不影响结果，所以直接排！
        for(int i = 0;i<nums.length;i++){
            // 分别找到左右各有几个元素，然后作差
            int r = lowerBound(nums,i,upper-nums[i]+1);
            int l = lowerBound(nums,i,lower-nums[i]);
            ans += r-l;
        }
        return ans;

    }

    // 返回第一个大于等于target的下标(也相当于小于target的个数)
    // 如果想要转换成小于等于target 给target加一即可

    private int lowerBound(int[] nums,int right,int target){

        int left = -1;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid;
            }
            else{
                left=mid;
            }
        }
        return right;
    }

}