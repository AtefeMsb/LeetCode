// two coordinates are on the same diagonal if and only if r1 - c1 == r2 - c2
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        Map<Integer, Integer> groupMap = new HashMap<>();
        
        for (int r = 0; r < matrix.length; r++) {   // row  
            for (int c = 0; c < matrix[0].length; c++) {    // col
                // if group is empty, create one
                if (!groupMap.containsKey(r - c)) {
                    groupMap.put(r - c, matrix[r][c]);
                // check the value of the coordinates group
                } else {
                    if (groupMap.get(r - c) != matrix[r][c]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
