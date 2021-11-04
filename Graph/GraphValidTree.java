/**
 * 3 conditions for a GRAPH to be a TREE:
 * 1.   number of edge == number of vertices - 1
 * 2.   tree has no cycle
 * 3.   tree are connected
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        // an empty graph is a tree
        if (n == 0) return true;
        
        // first condition for tree: number of edge == number of vertices - 1
        if (edges.length != n - 1) return false;
        
        
        // create graph (adjacency list)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        // second condition for tree: tree has no cycle
        // third condition for tree: tree are connected
        return !dfs(graph, visited, 0, -1) && visited.size() == n;
        
    }
    
    // does cycle exists in the undirected graph
    // using visited set and dfs
    public boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node, int prev) {
        if (visited.contains(node)) return true;
        visited.add(node);
        
        for (int neigh : graph.get(node)) {
            if (neigh == prev)  continue;
            if (dfs(graph, visited, neigh , node)) {
                return true;
            }   
        }
        
        return false;
    }
}