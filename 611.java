class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int k=2;k<nums.length;k++){
            int c = nums[k];
            int i=0;
            int j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>c){
                    ans+=j-i;
                    j--;
                }
                else{
                    i++;
                }
            }
        }
        return ans;
    }
}