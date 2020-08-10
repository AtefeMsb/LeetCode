package AuguestChallenge2020;

import java.util.ArrayDeque;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();

        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for (int r = 0; r < ROWS; ++r)
            for (int c = 0; c < COLS; ++c)
                if (grid[r][c] == 2)
                    queue.offer(new Pair(r, c));
                else if (grid[r][c] == 1)
                    freshOranges++;

        // Mark the round/level, i.e. the ticker of timestamp
        queue.offer(new Pair(-1, -1));

        System.out.println(queue);
        System.out.println(freshOranges);
        
        // Step 2). start the rotting process via BFS
        int minutesElapsed = 0;
        // left, right, down, up
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            
            // if hit an end of the round
            if (row == -1) {
                
                // We finish one round of processing
                minutesElapsed++;
                
                // to avoid the endless loop - put the ticker of timestamp for the next round
                if (!queue.isEmpty()) {
                    queue.offer(new Pair(-1, -1));
                }
                
            } else {
                
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    // if this direction exists
                    if (neighborRow >= 0 && neighborRow < ROWS && 
                        neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.offer(new Pair(neighborRow, neighborCol));

                        }
                    }
                }
            }
        }

        // return elapsed minutes if no fresh orange left
        // // REASON FOR minutesElapsed - 1: Because we do count++ every time when queue is not empty.
        //  When there is no fresh orange, it still does count++ at the begin of the while loop.
        return freshOranges == 0 ? minutesElapsed - 1 : -1;
    }
}