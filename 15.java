class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        for(int k=0;k<nums.length-2;k++){
            if(nums[k]>0)
                break;
            if(k>0&&nums[k]==nums[k-1])
                continue;
            int i=k+1,j=nums.length-1;
            while(i<j){
                int sum =nums[k]+nums[i]+nums[j];
                if(sum<0){
                    while(i<j&&nums[i]==nums[++i]);
                }
                else if(sum>0){
                    while(i<j&&nums[j]==nums[--j]);
                }
                else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i<j&&nums[i]==nums[++i]);
                    while(i<j&&nums[j]==nums[--j]);
                }
            }
        }
        return res;
    }
}


class Solution {
    /**
        整体的流程：
        先排序
        然后限定一个范围，这个范围从左往右递增
        在范围内进行双指针
        如果双指针时，出现了重复的元素，需要通过移动指针的方式消除重复
        结束后判断sum的大小，然后据次移动指针的方向
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums==null || len<3)
            return ans;
        Arrays.sort(nums);
        // 固定的是边界线，让left和right在边界范围里面双向指针
        // 双指针的复杂度一般为O(n)
        for(int i = 0;i<len;i++){
            // 优化
            if(nums[i]>0)
                break;
            // 从前往后处理，所以前面的重复对于i而言已经处理过的
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 不能有相同的两个元素同时加入到list中，我们并不在乎个数，只在乎种类，所以要去重
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    // 刚刚那一步，是移动到了最后一个重复的，所以现在要移动到第一个不重复的
                    left++;
                    right--;
                }
                // 这部分才是正经的双指针递推
                else if(sum<0) left++;
                else if(sum>0) right--;
            }
        }
        return ans;
    }
    
}


// 自己做的方法
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i-1>=0&&nums[i]==nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left+1<right&&nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left<right-1&&nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}