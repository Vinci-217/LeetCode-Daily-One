class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;


        boolean[] col = new boolean[n];
        boolean[] row = new boolean[m];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i] = col[j] = true;
                }
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(row[i]||col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}