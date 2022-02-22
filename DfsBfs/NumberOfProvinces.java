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

// ----------------------------------------------------------
// dfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }
    
    public void dfs(int[][] isConnected, Set<Integer> visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited.contains(j)) {
                visited.add(j);
                dfs(isConnected, visited, j);
            }
        }
    }
}

// --------------------------------------------------------
// bfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        if (isConnected == null || isConnected.length == 0) return 0;
        
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        
        for (int row = 0; row < isConnected.length; row++) {
            if (!visited.contains(row)) {
                count++;
                queue.add(row);
                
                while (!queue.isEmpty()) {
                    int cur = queue.remove();
                    visited.add(cur);
                    for (int col = 0; col < isConnected.length; col++) {
                        if (isConnected[cur][col] == 1 && !visited.contains(col)) {
                            queue.add(col);
                        }
                    }
                }
                
            }
        
        }
       
        return count;
    }
}