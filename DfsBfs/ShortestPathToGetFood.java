class Solution {
    
    int[][] directions = new int[][] {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};
    public int getFood(char[][] grid) {
        
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        // find the start
        int[] start = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*'){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    break;
                }
            }
        }
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                
                int[] cur = queue.remove();
                int x = cur[0];
                int y = cur[1];
                
                // if found
                if (grid[x][y] == '#') {
                    return steps;
                }
                
                for (int[] dir : directions) {
                    int r = x + dir[0];
                    int c = y + dir[1];
                    
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
                        continue;
                    }
                    
                    if (grid[r][c] != 'X') {
                        int[] cell = new int[]{r, c};
                        if (visited[r][c] == false) {
                            queue.add(cell);
                            visited[r][c] = true;
                        }    
                    }  
                }
                   
            }
            
            steps++;
        }
        
        return -1;
    }
}