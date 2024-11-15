// 第一次做法，其实应该先合并排序然后直接找中位数
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];
        int cur = 0;
        int c1 = 0;
        int c2 = 0;
        while (c1 < m && c2 < n) {
            if (nums1[c1] < nums2[c2]) {
                ans[cur] = nums1[c1];
                cur++;
                c1++;
            } else {
                ans[cur] = nums2[c2];
                c2++;
                cur++;
            }
        }
        if (c1 == m) {
            while (c2<n) {
                ans[cur] = nums2[c2];
                cur++;
                c2++;
            }
        }
        if (c2 == n) {
            while (c1<m) {
                ans[cur] = nums1[c1];
                cur++;
                c1++;
            }
        }
        if((m+n)%2==0)
            return (double)(ans[(m+n)/2]+ans[(m+n)/2-1])/2;
        return ans[(m+n)/2];

    }
}