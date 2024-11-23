class Solution {
    private char[][] board;
    private int[][] flag;
    private StringBuilder path;
    private String word;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j,int index) {
        if(index == word.length()){
            return true;
        }

        if(i<0||i>=m||j<0||j>=n||board[i][j]!=word.charAt(index)){
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '#';
        index++;
        boolean flg = dfs(i-1,j,index)||dfs(i+1,j,index)||dfs(i,j-1,index)||dfs(i,j+1,index);
        index--;
        board[i][j] = tmp;
        return flg;
    }
}