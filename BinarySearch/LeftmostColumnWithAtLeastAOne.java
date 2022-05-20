/* binary search for each row
Time complexity : O(N \, \log \, M)O(NlogM).

There are MM items in each row. Therefore, each binary search will have a cost of O(logM). We are performing NN of these binary searches,
giving a time complexity of N⋅O(logM)=O(NlogM).
*/

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        List<Integer> dimension = binaryMatrix.dimensions();
        int rows = dimension.get(0);
        int cols = dimension.get(1);
        
        int firstColWithOne = cols;
        
        for (int row = 0; row < rows; row++) {
            
            int left = 0;
            int right = cols - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (left == right) {
                    if (binaryMatrix.get(row, mid) == 1) {
                        firstColWithOne = Math.min(firstColWithOne, mid);
                        break;
                    }
                }
                
                if (binaryMatrix.get(row, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
          
            }
      
        }

        return firstColWithOne == cols ? -1 : firstColWithOne;
    }
}
// -------------------------------------------------------------
/*
simulation
Let N be the number of rows, and M be the number of columns.

Time complexity : O(N + M)

At each step, we're moving 1 step left or 1 step down. Therefore, we'll always finish looking
at either one of the M rows or N columns. Therefore, we'll stay in the grid for at most N + M steps,
and therefore get a time complexity of O(N + M).
*/

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = cols - 1;
    
        // Repeat the search until it goes off the grid.
        while (currentRow < rows && currentCol >= 0) {
            int val = binaryMatrix.get(currentRow, currentCol);
            if (val == 0) {
                currentRow++;
            } else if (val == 1) {
                currentCol--; 
            }
        }
    
        // If we never left the last column, this is because it was all 0's.
        return (currentCol == cols - 1) ? -1 : currentCol + 1;
    }
}