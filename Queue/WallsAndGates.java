package Queue;

class WallsAndGates {
    
    private static final int EMPTY = r;
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
        /**
         * I think what some folks are missing in this solution is that each gate is
         * not fully searched before moving on to a new gate. Each gate only looks at the areas
         * within 1 space before we check the next gate. So each area within one space of the
         * gates are checked for rooms and these rooms are marked, then added to the queue.
         * Once all gates are checked, each new space is checked, and so forth. So, once a room gets hit, it has to be from the closest gate.
         */
        
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

/////////////////////////////////////////////////////////
// dfs
// source : https://www.youtube.com/watch?v=Pj9378ZsCh4&ab_channel=KevinNaughtonJr.
class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                // start the search from each gate
                if (rooms[i][j] == 0) {
                    dfs(i, j, rooms, 0);
                }
            }
        }
                
    }
    
    private void dfs(int i, int j, int[][] rooms, int count) {
        
        // base case - when the search ends
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < count) {
            return;
        }
        
        rooms[i][j] = count;
        dfs(i - 1, j, rooms, count + 1);
        dfs(i + 1, j, rooms, count + 1);
        dfs(i, j - 1, rooms, count + 1);
        dfs(i, j + 1, rooms, count + 1);
    }
}i