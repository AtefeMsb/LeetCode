/**
 * DFS - backtracking
 */
class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> result = new ArrayList<>();
       dfs(graph, 0, new ArrayList<Integer>(), result);
       return result;
    }
    
    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        
        // 1. choose
        path.add(node);
        
        // base case - if destination is found
        if (node == graph.length - 1) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int neighbor : graph[node]) {
            // 2. explore
            dfs(graph, neighbor, path, result);
            // 3. backtrack
            path.remove(path.size() - 1);
        }
            
    }
}
