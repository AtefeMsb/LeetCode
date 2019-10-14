class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        
        int resultCount = r * c;
        int originalCount = nums.length * nums[0].length;
        // check if it is possible to put the original aray into the reault array
        if (resultCount != originalCount) return nums;
        
        int[][] result = new int[r][c];
        // row and col are used for setting result array elemnts
        int row = 0;
        int col = 0;
        // traversing the original array and copy it into the result
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                result[row][col] = nums[i][j];
                col++;
                // if col reach the c, it is time for a new row
                if (col == c) {
                    row++;
                    col = 0;
                }
            }
            
        }
        
        return result;
    }
}
