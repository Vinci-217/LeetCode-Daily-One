class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length+1;
        while(left+1<right){
            int mid = left+right>>>1;
            if(citations[citations.length-mid]>=mid){
                left=mid;
            }
            else{
                right=mid;
            }
        }
        return left;

    }
    
}