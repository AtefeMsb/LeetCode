class Solution {
    
    // saves the local coordinate of each island 
    Set<List<List<Integer>>> uniqueIslands = new HashSet<>();
    // save all the cells of each island
    List<List<Integer>> current = new ArrayList<>();
    
    int StartRow;
    int StartCol;
    
    public int numDistinctIslands(int[][] grid) {
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                StartRow = i;
                StartCol = j;
                
                dfs(grid, i, j);
                
                if (current.isEmpty()) {
                    continue;
                }
                
                uniqueIslands.add(current);
                
                // start a new current list
                current = new ArrayList<>();
            }
        }
        return uniqueIslands.size();  
    }
    
    private void dfs(int[][] grid, int row, int col) {
        
        // boundry check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        
        grid[row][col] = 0;
        
        // add the local coordinate in the current
        current.add(List.of(row - StartRow, col - StartCol));
        
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}