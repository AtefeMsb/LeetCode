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