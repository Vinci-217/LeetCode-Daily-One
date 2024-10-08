class Solution {
    public int trap(int[] height) {

        // 方法一：先左右遍历，分别求出前缀最大和后缀最大，然后从左向右遍历

        // int[] pre_max = new int[height.length];
        // pre_max[0] = height[0];
        // for(int i=1;i<height.length;i++){
        //     pre_max[i] = Math.max(height[i],pre_max[i-1]);
        // }

        // int[] suf_max = new int[height.length];
        // suf_max[height.length-1]=height[height.length-1];
        // for(int i=height.length-2;i>=0;i--){
        //     suf_max[i] = Math.max(height[i],suf_max[i+1]);
        // }
        // int res = 0;
        // for(int i=0;i<height.length;i++){
        //     res+=Math.min(suf_max[i],pre_max[i])-height[i];
        // }
        // return res;

        // 方法二：如果前缀最大小于后缀最大，那么根据木桶效应，最多也就是前缀最大了，反之同理。然后从左右向中间扩展
        int n = height.length;
        int left = 0;
        int right = n-1;
        int res = 0;
        int pre_max = height[0];
        int suf_max = height[n-1];
        while(left<=right){
            pre_max = Math.max(height[left],pre_max);
            suf_max = Math.max(height[right],suf_max);
            if(pre_max<suf_max){
                res+=pre_max-height[left];
                left++;
            }
            else{
                res+=suf_max-height[right];
                right--;
            }
        }
        return res;
    }
}

// 第二次自己做，没做出来
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        int preMax = 0;
        int sufMax = 0;

        // 遍历的是每一条竖线，而不是面积

        while(left<right){
            // 求 前缀最大值 和 后缀最大值
            preMax = Math.max(preMax,height[left]);
            sufMax = Math.max(sufMax,height[right]);
            // 左右最小长度的雨水量，减去黑条长度
            ans += preMax < sufMax? preMax-height[left++] : sufMax-height[right--];
        }



        return ans;

    }
}