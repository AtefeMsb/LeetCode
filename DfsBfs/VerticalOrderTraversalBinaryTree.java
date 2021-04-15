package DfsBfs;

// each point is the representation of each node by its col,row,value
class Point {
    int col;
    int row;
    int val;
    
    public Point (int c, int r, int v) {
        col = c;
        row = r;
        val = v;
    }
   
    public String toString() { 
    return "Col:" + col + " Row:" + row + " Value:" + val;
} 
}

class Solution {
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    
        // priority queue
        PriorityQueue<Point> pq = new PriorityQueue(new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.col != p2.col) {
                    return p1.col - p2.col;
                } else if (p1.row != p2.row) {
                    return p1.row - p2.row;
                } else {
                    return p1.val - p2.val;
                }
            }
        });
        
        // mark each node with (col, row, val) and put them in the priority queue
        dfs(root, 0, 0, pq);
        
        // built the result list
        int currentCol = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        
        // get each Point out of priorityQueue and put the one with similar col to a list
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            
            if (cur.col != currentCol) {
                currentCol = cur.col;
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(cur.val);
        }
        
        return result;
    }
    
    
    // traverse the tree using dfs and marking each node by (col, row, val)
    private void dfs(TreeNode root, int col, int row, PriorityQueue<Point> pq) {
        if (root == null) return;
        pq.offer(new Point(col, row, root.val));
        dfs(root.left, col - 1, row + 1, pq);
        dfs(root.right, col + 1, row + 1, pq);
    }
}

/*
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> {
          if (p1.col != p2.col) {
              return p1.col - p2.col;
          } else if (p1.row != p2.row) {
              return p1.row - p2.row;
          } else {
              return p1.val - p2.val;
          }
        }
*/