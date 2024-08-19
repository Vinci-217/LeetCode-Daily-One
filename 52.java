
class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    int[] chessboard; // 存储第i行的皇后在第几列

    public int totalNQueens(int n) {
        chessboard = new int[n];
        dfs(0, n);
        return ans.size();
    }

    private void dfs(int row,int n){
        if(row==n){
            ans.add(new ArrayList<>(path));
            return ;
        }
        // 以行为单位进行遍历
        for(int i = 0;i<n;i++){
            if(!isValid(row,i))
                continue;
            StringBuilder str=new StringBuilder();
            // 构造字符串
            for(int j = 0;j<n;j++){
                if(j!=i)
                    str.append('.');
                else
                    str.append('Q');
            }

            // 有
            path.add(str.toString());
            chessboard[row]=i;
            dfs(row+1,n);
            // 恢复现场
            path.remove(path.size()-1);
            chessboard[row]=0;
        }


    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i] == col)
                return false;
            if (chessboard[i] + i == row + col)
                return false;
            if (chessboard[i] - i == col - row)
                return false;
        }
        return true;
    }
}