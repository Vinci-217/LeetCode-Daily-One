// 方法1：三次翻转
class Solution {
    public void rotate(int[] nums, int k) {
        int n  =nums.length;
        k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    private void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}

// 方法2： 量数组
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[(i+k)%n] = nums[i];
        }
        System.arraycopy(arr,0,nums,0,n);
    }

}