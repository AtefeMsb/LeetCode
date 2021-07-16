/**
 * using extra space
 */
class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        int[][] count = new int[m][n];
        
        // create a matrix of count of live neighbords for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;
                
                // vertical
                if (i > 0 && board[i - 1][j] == 1) liveCount++;
                if (i < m - 1 && board[i + 1][j] == 1) liveCount++;
                
                // horizontal
                if (j > 0 && board[i][j - 1] == 1) liveCount++;
                if (j < n -1 && board[i][j + 1] == 1) liveCount++;
                
                // diagnoal
                if (i > 0 && j < n - 1 && board[i - 1][j + 1] == 1) liveCount++;
                if (i > 0 && j > 0  && board[i - 1][j - 1] == 1) liveCount++;
                if (i < m - 1 && j > 0 && board[i + 1][j - 1] == 1) liveCount++;
                if (i < m - 1 && j < n - 1 && board[i + 1][j + 1] == 1) liveCount++;
                
                count[i][j] = liveCount;
                // System.out.println("i:"+ i+ " j:"+ j + " liveCount:" + liveCount);
            }  
        }
        
        // apply the rules of life for each cell using the "count matrix"
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = count[i][j];
                if (board[i][j] == 1 && liveNeighbors < 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 1 && liveNeighbors == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 1 && liveNeighbors == 3) {
                    board[i][j] = 1;
                } else if (board[i][j] == 1 && liveNeighbors > 3) {
                    board[i][j] = 0;
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 1;
                }
            }
        }
        
        
    }
}
// -----------------------------------------------------------------
/*
original - new -> sybmol
0 - 0 -> 0
1 - 0 -> 1
0 - 1 -> 2
1 - 1 -> 3
*/
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // apply the rules and update the symbol
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int liveCount = countLiveNeighbors(board, i, j, m, n);
                
                if (board[i][j] == 1 && liveCount < 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 1 && liveCount == 2) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && liveCount == 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && liveCount > 3) {
                    board[i][j] = 1;
                } else if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 2;
                }
        
            }
        }
        
        // change the sybmols to the actual new value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int val = board[i][j];
                if (val == 1) {
                    board[i][j] = 0;
                } else if (val == 2) {
                    board[i][j] = 1;
                } else if (val == 3) {
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
    // count live neighbors
    private int countLiveNeighbors(int[][] board, int r, int c, int m, int n) {
        
        int liveCount = 0;

        // check the surronding 8 neighbors
        for (int i =  r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; j++) {
                
                // ignore out of bound or the same location
                if ((i == r && j == c) || i < 0 || j < 0 || i >= m || j >= n) {
                    continue;
                } else if (board[i][j] == 1 || board[i][j] == 3) {
                    liveCount++;
                }
            }
        }
        
        return liveCount;
    }
            
}