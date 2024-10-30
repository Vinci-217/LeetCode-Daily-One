class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // 沿对角线翻转
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 沿每一行中点翻转
        int mid = n>>1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<mid;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
        
    }
}