package DfsBfs;

/* without optimization this solution would Time Limit Exceed */
class Solution {
    public int minKnightMoves(int x, int y) {
        
        // optimization 1: Turn our destination from (x,y) -> (abs(x) abs(y)).
        // vasically only search in the first quadrant, because of symmetry
        x = Math.abs(x);
        y = Math.abs(y);
       
        int moveCount = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0,0});
    
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        
        int[][] directions = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] cur = queue.pop();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == x && curY == y) {
                    return moveCount;
                }
                
                for (int[] direction : directions) {
                    int newX = curX + direction[0];
                    int newY = curY + direction[1];
                    String id = newX + "," + newY;
                    
                    // optimization 2: never visit already visited cells
                    // optimization 3: allow buffer for quadrant 1, for example when destination is (1,1)
                    if (!visited.contains(id) && newX >= -2 && newY >= -2) {
                        queue.add(new int[] {newX, newY});
                        visited.add(id);
                            
                    }
                }
            }
            
            moveCount++;
        }
        
        return -1;
        
    }
}