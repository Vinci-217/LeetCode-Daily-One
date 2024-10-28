class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(p,q)->p[0]-q[0]);
        List<int[]> ans = new ArrayList<>();
        for(int[] row:intervals){
            int m = ans.size();
            if(m>0&&ans.get(m-1)[1]>=row[0]){
                ans.get(m-1)[1] = Math.max(ans.get(m-1)[1],row[1]);
            }
            else{
                ans.add(row);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}