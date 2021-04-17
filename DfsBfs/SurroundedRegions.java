package DfsBfs;

class Solution {
    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;
        
        // 1- find all the edge cells
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);  // first column
            if (board[i][m - 1] == 'O') dfs(board, i, m - 1);  // last column
        }
           
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);  // first row
            if (board[n - 1][j] == 'O') dfs(board, n - 1, j);  // last row
            
        }
 
        // 2- return non-edge O-cell into X-cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if its 'O' convert to 'X'
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                // if its 'E' convert back to 'O'
                } else if (board[i][j] == 'E') {
                     board[i][j] = 'O';
                }
                
            }
        }
        
    }
    
    // converts each edge O-cell to E-cell
    private void dfs(char[][] board, int i, int j) {
        // base case
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = 'E';
        
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);  
    }
}