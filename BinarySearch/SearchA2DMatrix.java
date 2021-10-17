/**
 * binary search
 * time: log(m) + log(n)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // do a binary search to find the row that target might exist in it
        int top = 0;
        int bottom = rows - 1;
        
        while (top <= bottom) {
            int row = top + (bottom - top) / 2;
            if (target > matrix[row][cols - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bottom = row - 1;
            } else {
                break;
            }
        }
        
        // if no row that might have target was selected
        if (top > bottom) return false;
        
        // do a binary search on a selected row to look for the target
        int left = 0;
        int right = cols - 1;
        int row = top + (bottom - top) / 2;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                left = mid + 1; 
            } else if (target < matrix[row][mid]) {
                right = mid - 1;
            }
        }
        
        return false;
        
    }
}