// copy each row of A into col of transposedA
class Solution {
    public int[][] transpose(int[][] A) {
        
        int row = A.length;
        int col = A[0].length;
        
        int[][] transposedA = new int[col][row];
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                transposedA[c][r] = A[r][c];
            }
        }
        return transposedA;
    }
}
