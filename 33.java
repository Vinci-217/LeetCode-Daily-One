class Solution {
    public int search(int[] nums, int target) {
        int n1 = searchMin(nums,target);
        Arrays.sort(nums);
        int l = searchNum(nums,target);
        if(l==nums.length||nums[l]!=target){
            return -1;
        }
        return (n1+l)%nums.length;
    }

    private int searchNum(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
    private int searchMin(int[] nums,int target){
        int left = 0;
        int right = nums.length-2;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[nums.length-1]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        if(nums[nums.length-1]<nums[left]){
            return nums.length-1;
        }
        return left;
    }
}