package DfsBfs;

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;
        
        // add all the rotton oranges in the queue and also count number of fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // only if the cell is rotten, do the bfs
                if (grid[i][j] == 2) {
                    // add to the queue
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // early return when there is no fresh orange on the grid
        if (freshCount == 0) return 0;
  
        // process all the nodes in one level in one go, so we can count number of minutes pass (level by level)
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                // check all 4-directionally adjacent cells
                for (int[] direction : directions) {
                    int row = cur[0] + direction[0];
                    int col = cur[1] + direction[1];

                    // check the boundries and empty cells and already rotton
                    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || grid[row][col] == 2) {
                        continue;
                    } else if (grid[row][col] == 1) {
                        // turn it rotten
                        grid[row][col] = 2;
                        freshCount--;
                        queue.offer(new int[] {row, col});
                    }   
                }  
            }
            
            // each level further, one minute passes
            minutes++;
    
            // if already rotton every fresh oranges
            if (freshCount == 0) {
                return minutes;
            }
            
        }

      return -1;  
    }
}
