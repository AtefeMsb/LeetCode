class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        // 1. transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // 2. reverse each row of the matrix
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            
            while (left < right) {
               // swap te values of two pointers
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--; 
            }
            
        }
    }
}