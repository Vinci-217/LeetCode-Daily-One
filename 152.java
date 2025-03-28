class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fMax = new int[n];
        int[] fMin = new int[n];
        fMax[0] = fMin[0] = nums[0];
        for(int i = 1;i<n;i++){
            int x = nums[i];
            fMax[i] = Math.max(Math.max(fMax[i-1]*x,fMin[i-1]*x),x);
            fMin[i] = Math.min(Math.min(fMax[i-1]*x,fMin[i-1]*x),x);
        }
        return Arrays.stream(fMax).max().getAsInt();
    }
    
}