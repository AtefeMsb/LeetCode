class Solution {
    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
      
      public void cleanRoom(Robot robot) {
          dfs(robot, 0, 0, 0, new HashSet<String>());
    }
      
      public void dfs(Robot robot, int row, int col, int d, Set<String> visited) {
        
          visited.add(row + "-" + col);
          robot.clean();
        
          // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
          for (int i = 0; i < 4; i++) {
              int newD = (d + i) % 4;
              int newRow = row + directions[newD][0];
              int newCol = col + directions[newD][1];
  
              if (!visited.contains(newRow + "-" + newCol) && robot.move()) {
              dfs(robot, newRow, newCol, newD, visited);
  
              // backtrack
              robot.turnRight();
              robot.turnRight();
              robot.move();
              robot.turnRight();
              robot.turnRight();
          }
              
          // turn the robot following chosen direction : clockwise
          robot.turnRight();
              
          }
          
      }
  
  }