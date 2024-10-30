class Solution {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> ans = new ArrayList<>(m*n);
        int i = 0;
        int j = 0;
        int di = 0;
        for(int k = 0;k<m*n;k++){
            ans.add(matrix[i][j]);
            // 标记已经走过了
            matrix[i][j] = Integer.MAX_VALUE;
            // 下一步的位置
            int x = i+DIRS[di][0];
            int y = j+DIRS[di][1];
            // 如果出界或者已经访问过
            if(x<0 || x>=m || y<0 ||y>=n||matrix[x][y] == Integer.MAX_VALUE){
                di = (di+1)%4;
            }
            i += DIRS[di][0];
            j += DIRS[di][1];
        }

        return ans;
        
    }
}