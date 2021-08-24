/**
 * decrease the search space
 */
// start from the bottom-left corner
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int row = n - 1;
        int col = 0;
        
        while (row >= 0 && col < m) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                 row--;
            } else if (matrix[row][col] < target) {
                col++;
            }
        }
        
        return false;
        
    }
}
// ----------------------------------------
// start from top-right corner
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int col = m - 1;
        int row = 0;
        
        while (col >= 0 && row <= n - 1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}