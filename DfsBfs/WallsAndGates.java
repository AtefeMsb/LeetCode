package DfsBfs;

/* BFS: because all the gates are already on the queue, 
eveytime hit an EMPTY spot, it will be from the closest gate to it
so every spot gets updated only once from the closest gate to it */

class Solution {
    static final int EMPTY = Integer.MAX_VALUE;
    static final int GATE = 0;
    
    public void wallsAndGates(int[][] rooms) {
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (rooms == null || rooms.length == 0) return;
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // put all the gates in a queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == GATE) {
                    queue.add(new int[] {i,j});
                }
            }
        }
        
        // update the MEPTY cells level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
              for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                // check all 4-directionally adjacent cells
                for (int[] direction : directions) {
                    int row = cur[0] + direction[0];
                    int col = cur[1] + direction[1];

                    // check the boundries 
                    if (row < 0 || row >= n || col < 0 || col >= m || rooms[row][col] != EMPTY) {
                        continue;
                    }
                    
                    // if hit an EMPTY cell, update it
                    rooms[row][col] = rooms[cur[0]][cur[1]] + 1;
                    
                    queue.offer(new int[] {row, col});
                    
                }  
            }     
        } 
        
    }
}