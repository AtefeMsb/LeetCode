package Queue;

class WallsAndGates {
    
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int[][] DIRECTIONS = {{0, -1},{0, 1},{1, 0},{-1, 0}};
    
    public void wallsAndGates(int[][] rooms) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        // get the height and width of the grid
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        
        // add all the GATES in the queue at first
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        
        // BFS: because all the gates are already on the queue, 
        // eveytime hit an EMPTY spot, it will be from the closest gate to it
        // so every spot gets updated only once from the closest gate to it
        
        while (!queue.isEmpty()) {
            
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            
            // visit all the adjacent spots
            for (int[] direction: DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                
                // if indeces out-of-bounds or the point has been visited before means is not empty
                if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                
                rooms[r][c] = rooms[row][col] + 1;
                
                queue.add(new int[] {r, c});
            }
            
            
        }
    }
}