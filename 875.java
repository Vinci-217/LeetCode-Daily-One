class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }
        while(left+1<right){
            int mid = (left+right)>>>1;
            if(canEat(piles,mid,h)){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return right;
    }
    private boolean canEat(int[] piles,int mid,int h){
        int sum = piles.length;
        for (int pile : piles) {
            sum += (pile - 1) / mid;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }
}