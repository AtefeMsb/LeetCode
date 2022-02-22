class Solution {
    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;
        
        // 1. (DFS) capture unsurronded/edge regions (O -> T)
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);           // first col
            if (board[i][m - 1] == 'O') dfs(i, m - 1, board);   // last col
        }
        
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);           // first row
            if (board[n - 1][j] == 'O') dfs(n - 1, j, board);   // last row
        }
        
        // 2. captured surronded regions (O -> X)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        // 3. uncapture unsurronded regions (T -> O)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    // convert edge 'O' cells to 'T' cells
    public void dfs(int r, int c, char[][] board) {
        
        // base case
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        
        board[r][c] = 'T';
        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }
}