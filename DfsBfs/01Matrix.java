class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{{-1, 0}, {0, -1}, {+1, 0}, {0, +1}};
        
        // add all the 0 cells to the distance
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int i = 0; i < 4; i++) {
                int newR = dir[i][0] + cur[0];
                int newC = dir[i][1] + cur[1];
                
                if (newR < 0 || newR >= r || newC < 0 || newC >= c || mat[newR][newC] != -1) continue;
                    
                mat[newR][newC] = 1 + mat[cur[0]][cur[1]];
                queue.add(new int[]{newR, newC});
            }    
        }
        
        return mat;
    }
}