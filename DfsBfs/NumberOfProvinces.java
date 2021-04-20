package DfsBfs;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        
        int provinceCount = 0;
        // each cell is representative of a row
        int[] visited = new int[isConnected.length];
        
        for (int row = 0; row < isConnected.length; row++) {
            if (visited[row] == 0) {
                dfs(row, isConnected, visited);
                provinceCount++;
            }
            
        }
        
        return provinceCount;
    }
    
    private void dfs(int row, int[][] grid, int[] visited) {
        
        for (int col = 0; col < grid.length; col++) {
            // if tehre is connection and the col has not been seen before
            if (grid[row][col] == 1 && visited[col] == 0) {
                visited[col] = 1;
                dfs(col, grid, visited);
            }
        }
    
    }
}
