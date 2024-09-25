class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 倒序插入
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        // 只需要判断p2是否需要添加即可，因为p1本来就在这里面，不需要移动
        while(p2>=0){
            if(p1>=0&&nums1[p1]>nums2[p2]){
                nums1[p--]=nums1[p1--];
            }
            else{
                nums1[p--] = nums2[p2--];
            }
        }

    }
}