/**
 * time: O(mn)
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        // each cell is: best square ending at [r, c]
        int[][] dp = new int[n][m];
        // fill with zero
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] == '1') {
                    // at least it can create square of length 1
                    dp[r][c] = 1;
                    
                    // if not the first row and not the first col
                    // get the min of (cell on diagnal before, cell above, cell before)
                    if (r > 0 && c > 0) {
                        dp[r][c] += Math.min(dp[r-1][c-1], Math.min(dp[r-1][c], dp[r][c-1]));
                    }
                }
               
                max = Math.max(max, dp[r][c]);
            }
        }

        return max * max;
    }
}
