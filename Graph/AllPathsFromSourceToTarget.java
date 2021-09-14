/**
 * DFS - backtracking
 */
class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // all the paths start with 0
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }
    
    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        
        // base case - if destination is found
        if (node == graph.length - 1) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int neighbor : graph[node]) {
            // 1. choose
            path.add(neighbor);
            // 2. explore
            dfs(graph, neighbor, path, result);
            // 3. backtrack
            path.remove(path.size() - 1);
        }
            
    }
}

// -----------------------------------------------------------
/**
 * BFS
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<List<Integer>> queue = new LinkedList<>();
        int end = graph.length - 1;
        
        // all paths start from "0" and ends at "end"
        List<Integer> firstPath = new ArrayList<>();
        firstPath.add(0);
        queue.add(firstPath);
                
        while (!queue.isEmpty()) {
            
            // pop a path from teh queue and check its last element
            List<Integer> path = queue.remove();
            int lastNode = path.get(path.size() - 1);
            
            // 1. if the last element is equal end, means the path is complete
            if (lastNode == end) {
                result.add(new ArrayList<>(path));
            // 2. if not, add all the neighbors of last node to the path
            } else {
                int[] neighbors = graph[lastNode];
                for (int neighbor : neighbors) {
                    List<Integer> list = new ArrayList<>(path);
                    list.add(neighbor);
                    queue.add(list);
                }
             }
        }
        
        return result;
     
    }
}