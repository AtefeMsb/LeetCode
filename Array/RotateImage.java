class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        // 1. TRANSPOSE
        transpose(matrix, n);
        
        // 2. REFLECT
        reflect(matrix, n);
        
    }
    
    // reverse the matrix around the main diagonal (TRANSPOSE)
    private void transpose(int[][] matrix, int n) {
         for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                
                // swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    // reverse each row of the matrix from left to right (REFLECT)
    private void reflect(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            
            while (left < right) {
                // swap
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                
                left++;
                right--;
            }  
        }
    }
      
}