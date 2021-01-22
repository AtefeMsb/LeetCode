package recursion;

// Divide and Conqure
// time complexity : O(nlogn)
// space compelxity: O(logn)
class SearchA2DMatrix1 {
    
    // cache matrix and target here, so no need to pass them to recursiveSearch everytime
    int[][] mat;
    int targ;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        mat = matrix;
        targ = target;
        if (mat == null || mat.length == 0) {
            return false;
        }
        
        return recursiveSearch(0, matrix[0].length - 1, 0, matrix.length - 1);
 
    }
    
    private boolean recursiveSearch(int left, int right, int up, int down) {
        
        if (left > right || up > down) {
            return false;
            
        // `target` is already larger than the largest element or smaller
        // than the smallest element in this submatrix.
        } else if (targ < mat[up][left] || targ > mat[down][right]) {
            return false;
        }
        
        int mid = left + (right - left) / 2;
        
        // finding the 'row' that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;   // start from first row
        while (row <= down && mat[row][mid] <= targ) {
            if (mat[row][mid] == targ) {
                return true;
            }
            row++;  // continue going down
        }
        
        // 2 areas get DISCARDED:
        // first: left-up because all the elements within this sub-matrix would be less than the target value
        // second: right-down because all the elements within this sub-matrix would be greater than the target value. 
        return recursiveSearch(left, mid-1, row, down) ||
               recursiveSearch(mid+1, right, up, row-1);
        
    }
}
/////////////////////////////////////////////////////////////////////
// Search Space Reduction
// Time Complexity: O(n + m)
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        // start from the bottom-left
        int row = matrix.length - 1;
        int col = 0;
        
        while (row >= 0 && col <= matrix[0].length - 1) {
            
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {    // found the target
                return true;
            }
        }
        
        return false;
    }
}