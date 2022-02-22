// DFS
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

// ----------------------------------------------------------------
// BFS

public class Solution {
    public void solve(char[][] board) {
        
      if (board == null || board.length == 0) {
        return;
      }
        
      int rows = board.length;
      int cols = board[0].length;
  
      List<int[]> borders = new LinkedList<>();
        
      // Step 1). construct the list of border cells
      for (int r = 0; r < rows; r++) {
        borders.add(new int[]{r, 0});
        borders.add(new int[]{r, cols - 1});
      }
      for (int c = 0; c < cols; ++c) {
        borders.add(new int[]{0, c});
        borders.add(new int[]{rows - 1, c});
      }
  
      // Step 2). mark the escaped cells
      for (int[] b : borders) {
        bfs(board, b[0], b[1]);
      }
  
      // Step 3). flip the cells to their correct final states
      for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
          if (board[r][c] == 'O')
            board[r][c] = 'X';
          if (board[r][c] == 'T')
            board[r][c] = 'O';
        }
      }
    }
  
    protected void bfs(char[][] board, int r, int c) {
       int rows = board.length;
      int cols = board[0].length;
      LinkedList<int[]> queue = new LinkedList<>();
      queue.add(new int[]{r, c});
  
      while (!queue.isEmpty()) {
        int[] pair = queue.remove();
        int row = pair[0];
        int col = pair[1];
        if (board[row][col] != 'O')
          continue;
  
        board[row][col] = 'T';
        if (col < cols - 1)
          queue.offer(new int[]{row, col + 1});
        if (row < rows - 1)
          queue.offer(new int[]{row + 1, col});
        if (col > 0)
          queue.offer(new int[]{row, col - 1});
        if (row > 0)
          queue.offer(new int[]{row - 1, col});
      }
    }
  }  