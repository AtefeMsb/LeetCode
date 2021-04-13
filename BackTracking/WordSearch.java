package BackTracking;

class Solution {
    private char[][] board;
    private int ROWS;
    private int COLS;
  
    public boolean exist(char[][] board, String word) {
      this.board = board;
      this.ROWS = board.length;
      this.COLS = board[0].length;
  
      for (int i = 0; i < this.ROWS; ++i)
        for (int j = 0; j < this.COLS; ++j)
          if (this.backtrack(i, j, word, 0))
            return true;
        
      return false;
    }
  
    // Dfs search
    protected boolean backtrack(int row, int col, String word, int index) {
      /* Step 1). check the bottom case. */
      if (index >= word.length())
        return true;
  
      /* Step 2). Check the boundaries. */
      if (row < 0 || row >= this.ROWS || col < 0 || col >= this.COLS || this.board[row][col] != word.charAt(index)) {
        return false;
      }
  
      /* Step 3). explore the neighbors in DFS */
      char temp = board[row][col];
      // mark the path before the next exploration
      this.board[row][col] = '#';
  
      boolean found = backtrack(row + 1, col, word, index + 1) 
          ||          backtrack(row - 1, col, word, index + 1) 
          ||          backtrack(row, col + 1, word, index + 1) 
          ||          backtrack(row, col - 1, word, index + 1);
          
      /* Step 4). clean up and return the result. */
      this.board[row][col] = temp;
        
      return found;
    }
  }  
