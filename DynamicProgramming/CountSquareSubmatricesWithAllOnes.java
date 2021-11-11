class Solution {
    public int countSquares(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
         for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        
        int result = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] == 1) {
                    // first row and first col
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                        result += 1;
                    // other rows
                    } else {
                        // each cell value is the actual matrix value + the minimum value of its links
                        int val = matrix[r][c] + Math.min(dp[r-1][c-1], Math.min(dp[r-1][c], dp[r][c-1]));
                        dp[r][c] = val;
                        result += val;
                    }
                    
                }
            }
        }
        
        return result;  
    }
}