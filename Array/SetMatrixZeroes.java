class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean firstRow = false;
        
        // use the first row as indicator for the columns
        // use the first col as indicator for the rows
        // use firstRow as indicator for the first row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    
                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        firstRow = true;
                    }   
                }
            }
        }
        
        // set the zero for anything that has at least a column or row in zero
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        // if the element[0][0] is 0, zero the first column
        if (matrix[0][0] == 0) {
            for (int r = 0; r < n; r++) {
                matrix[r][0] = 0;
            } 
        }
        
        // if firstRow is true, zero the first row
        if (firstRow == true) {
            for (int c = 0; c < m; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}