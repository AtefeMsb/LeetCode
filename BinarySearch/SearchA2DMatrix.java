/** binary search
 * time: O(log(mn))
 * space: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int left = 0;
        int right = row * col - 1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int middleValue = matrix[middle / col][middle % col];
            
            if (target == middleValue) {
                return true;
            } else if (target < middleValue) {
                 right = middle - 1;
            } else if (target > middleValue) {
                left = middle + 1;
            }
        }
        
        return false;
        
    }
}