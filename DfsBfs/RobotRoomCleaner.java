package DfsBfs;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<String>());
    }
    
    private void dfs(Robot robot, int x, int y, int direction, Set<String> seen) {
        
        // represnter of each cell
        String id = x + "," + y;
        
        // base case
        if (seen.contains(id)) return;
        
        // it is a new cell, clean it and put in seen
        robot.clean();
        seen.add(id);
        
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; i++) {
            // NO OBSTACLE
            if (robot.move()) {
                int nextX = x;
                int nextY = y;
                
                // because direction knew how to change the new x and y
                switch(direction) {
                    case 0: 
                        nextY = nextY - 1;
                        break;
                    case 90:
                        nextX = nextX + 1;
                        break;
                    case 180:
                        nextY = nextY + 1;
                        break;
                    case 270:
                        nextX = nextX - 1;     
                }
                
                // do the dfs for this branch
                dfs(robot, nextX, nextY, direction, seen);
                
                // Backtrack, i.e. go back to the previous cell.
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            
            // OBSTACLE - Turn right because now there is an obstacle just in front.
            // change and normalize the direction
            direction = direction + 90;
            direction = direction % 360;
            
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
            }
        
    }
}
