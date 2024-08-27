class Solution {
    public void moveZeroes(int[] nums) {
        // if(nums==null){
        //     return;
        // }        

        // int j=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         nums[j++]=nums[i];
        //     }
        // }
        // for(int i=j;i<nums.length;i++){
        //     nums[i]=0;
        // }

        if(nums ==null){
            return;
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int tmp =nums[i];
                nums[i]=nums[j];
                nums[j++]=tmp;
            }
        }

    }
}

// 第二次自己做的版本
class Solution {
    public void moveZeroes(int[] nums) {
        int left = -1;

        // O(n)
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                left = i;
                break;
            }

        }
        if(left==-1)
            return;

        int right = left+1;
        if(right>=nums.length)
            return;
        while(nums[right]==0){
            right++;
            if(right>=nums.length)
                break;

        }
        while (right<nums.length){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
                while(nums[left]!=0)
                    left++;
                right=left+1;
                if(right>=nums.length)
                    break;
                while(nums[right]==0){
                    right++;
                    if(right>=nums.length)
                        break;

                }

            }
        }

    }

    private void swap(int[] nums, int left ,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

