class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row :matrix){
            int index = search(row,target);
            if(index>=0){
                return true;
            }
        }
        return false;
    }


    private int search(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            int num = nums[mid];
            if(num==target){
                return mid;
            }
            else if(target>num){
                left = mid+1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}