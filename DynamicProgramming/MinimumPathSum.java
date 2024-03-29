// dynamic programming 
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j];
                // only from UP and LEFT
                // anywhere besides starting row and column
                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                   // only from up
                } else if (i > 0) {  
                    dp[i][j] += dp[i - 1][j];
                    // only from left
                } else if (j > 0) {
                     dp[i][j] += dp[i][j - 1];
                }  
            }
        }
        
        // return bottom-right corner
        return dp[dp.length - 1][dp[0].length - 1];
    }
}