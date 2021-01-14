package Graph;

/// DFS
class NumberOfIslands {
    void dfs(char[][] grid, int r, int c) {
      int nr = grid.length;
      int nc = grid[0].length;
  
      if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
        return;
      }
  
      // sink the island
      grid[r][c] = '0';

      // visit all its neighbors
      dfs(grid, r - 1, c);
      dfs(grid, r + 1, c);
      dfs(grid, r, c - 1);
      dfs(grid, r, c + 1);
    }
  
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
        return 0;
      }
  
      int nr = grid.length;
      int nc = grid[0].length;
      int num_islands = 0;

      for (int r = 0; r < nr; ++r) {
        for (int c = 0; c < nc; ++c) {
            // encounter an island
          if (grid[r][c] == '1') {
            ++num_islands;
            dfs(grid, r, c);
          }
        }
      }
  
      return num_islands;
    }
  }

//////////////////////////////////////////////
//BFS

// bfs
class Solution {
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // found an island
                if (grid[i][j] == '1') {
                    numIslands++;
                    
                    // sink the node
                    grid[i][j] = '0';
                    
                    // trigger a bfs search
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    
                    while (!queue.isEmpty()) {
                        
                        int[] point = queue.poll();
                        int r = point[0];
                        int c = point[1];
                        
                        grid[r][c] = '0';
                        
                        // each two together represents left, right, north, south
                        int[] offsets = {0, 1, 0, -1, 0};
                        
                        for (int k = 0; k < 4; k++) {
                            
                            int row = r + offsets[k];
                            int col = c + offsets[k + 1];
                            
                            if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1') {
                                grid[row][col] = '0';
                                queue.add(new int[] {row, col});
                                
                            }
                        }
                        
                    }
                  
                }
                
            }
        }
        
        return numIslands; 
    }
}