/**
 * DFS
 * time complexity: O(M×N) where M is the number of rows and N is the number of columns.
 * space complexity: worst case O(M×N) in case that the grid map is filled with lands where DFS goes by times M×N deep.
 */
class Solution {
    public int numIslands(char[][] grid) {
        
        int islandCount = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // if found a land, add to cound and explor the whole surronding
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(i, j, grid);
                }
            }
        }
        
        return islandCount;
    }
    
    private void dfs(int i, int j, char[][] grid) {
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
        
    }
}
// ------------------------------------------------
/**
 * BFS
 * time complexity: O(M×N) where M is the number of rows and N is the number of columns.
 * O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N).
 */
class Solution {
  public int numIslands(char[][] grid) {
      
      int res = 0;
      LinkedList<int[]> queue = new LinkedList<>();
      int[][] dir = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};
      
      for (int i = 0; i < grid.length; i++) {
          for (int j = 0; j < grid[0].length; j++) {
              
              if (grid[i][j] == '0') continue;
              if (grid[i][j] == '1') res++;
              grid[i][j] = '0';
              queue.add(new int[]{i, j});
              
              // start a bfs
              while (!queue.isEmpty()) {
                  
                  int[] cur = queue.pop();
                  int r = cur[0];
                  int c = cur[1];
                  
                  for (int[] d : dir) {
                      
                      int newR = r + d[0];
                      int newC = c + d[1];
                      
                      if (newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[0].length || grid[newR][newC] == '0') {
                          continue;
                      }
                      
                      grid[newR][newC] = '0';
                      queue.add(new int[]{newR, newC});
                  
                  }    
              }
                
          }
      }
      
      return res;  
  }
}
// -----------------------------------------
/**
 * union find
 * Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
 * Note that Union operation takes essentially constant time, when UnionFind is implemented with both path compression and union by rank.
 * Space complexity : O(M×N) as required by UnionFind data structure
 */

class Solution3 {
    class UnionFind {
      int count; // # of connected components
      int[] parent;
      int[] rank;
  
      public UnionFind(char[][] grid) { // for problem 200
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m; ++i) {
          for (int j = 0; j < n; ++j) {
            if (grid[i][j] == '1') {
              parent[i * n + j] = i * n + j;
              ++count;
            }
            rank[i * n + j] = 0;
          }
        }
      }
  
      public int find(int i) { // path compression
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
      }
  
      public void union(int x, int y) { // union with rank
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
          if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
          } else if (rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
          } else {
            parent[rooty] = rootx;
            rank[rootx] += 1;
          }
          --count;
        }
      }
  
      public int getCount() {
        return count;
      }
    }
  
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
        return 0;
      }
  
      int nr = grid.length;
      int nc = grid[0].length;
      int num_islands = 0;
      UnionFind uf = new UnionFind(grid);
      for (int r = 0; r < nr; ++r) {
        for (int c = 0; c < nc; ++c) {
          if (grid[r][c] == '1') {
            grid[r][c] = '0';
            if (r - 1 >= 0 && grid[r-1][c] == '1') {
              uf.union(r * nc + c, (r-1) * nc + c);
            }
            if (r + 1 < nr && grid[r+1][c] == '1') {
              uf.union(r * nc + c, (r+1) * nc + c);
            }
            if (c - 1 >= 0 && grid[r][c-1] == '1') {
              uf.union(r * nc + c, r * nc + c - 1);
            }
            if (c + 1 < nc && grid[r][c+1] == '1') {
              uf.union(r * nc + c, r * nc + c + 1);
            }
          }
        }
      }
  
      return uf.getCount();
    }
  }
  /**
  * another BFS
  */

  class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);  
                }
            }
        }
        
        return count; 
    }
    
    private void bfs(char[][] grid, int i, int j) {
        
        LinkedList<int[]> queue = new LinkedList<>();  
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {

            int[] point = queue.remove();
            int r = point[0];
            int c = point[1];

            grid[r][c] = '0';

            int[][] directions = {{0, -1},{0, 1},{1, 0},{-1, 0}};

            for (int[] dir : directions) {
                int row = r + dir[0];
                int col = c + dir[1];

                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
                    queue.add(new int[]{row, col});
                    grid[row][col] = '0';
                }

            }

        }
        
    }
}