/**
 * time: O(n)
 * space: O(n ^ 2)
 */
class TicTacToe {

    private int[][] board;
    private int n;

    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        // check if the player wins
        if ((checkRow(row, player)) ||
            (checkColumn(col, player)) ||
            (row == col && checkDiagonal(player)) ||
            (col == n - row - 1 && checkAntiDiagonal(player))) {
            return player;
        }
        // No one wins
        return 0;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }
}
// ---------------------------------------------------
/**
 * use rows, cols and 2 attributes to keep the counter for each player instead of keeping the whole board
 * time: O(1)
 * space: O(1)
 */
class TicTacToe {
    
    int[] rows;
    int[] cols;
    int diagonal = 0;
    int antiDiagonal = 0;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // for player1 add 1 and for player2 subtract 1
        int point = (player == 1) ? 1 : -1;
        
        rows[row] += point;
        cols[col] += point;
        if (row == col) {
            diagonal += point;
        }
        if (row == n - col - 1) {
            antiDiagonal += point;
        }
        
        if (Math.abs(rows[row]) == n ||
           Math.abs(cols[col]) == n ||
           Math.abs(diagonal) == n ||
           Math.abs(antiDiagonal) == n) {
            return player;
        } 
        
        return 0;
   
    }
}