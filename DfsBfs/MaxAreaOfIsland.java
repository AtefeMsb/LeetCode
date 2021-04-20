package DfsBfs;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0;
        
        // initialize the serach from each cell
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                maxArea = Math.max(maxArea, dfs(i, j, grid));
                
            }
        }
    
        return maxArea;
    }
    
    
    private int dfs(int row, int col, int[][] grid) {
        
        // out of bound check - water check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        
        // sink the cell
        grid[row][col] = 0;
        
        // explore the 4 directions
        return  1 + 
                dfs(row - 1, col, grid) + dfs(row + 1, col, grid) +
                dfs(row, col - 1, grid) + dfs(row, col + 1, grid);
        
    }
}
