class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowBound(nums,target);
        if(start==nums.length||nums[start]!=target){
            return new int[] {-1,-1};
        }
        int end = lowBound(nums,target+1)-1;
        return new int[]{start,end};
    }
    private int lowBound(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return left;

    }
}

// 第二次做法
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int n1 = search(nums,target);
        if(n1==nums.length||nums[n1]!=target){
            return new int[]{-1,-1};
        }
        int n2 = search(nums,target+1);
        return new int[]{n1,n2-1};
    }

    private int search(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
}