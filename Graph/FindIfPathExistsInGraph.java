class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) {
            return true;
        }
        // 1. create the graph (adjacency list)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            
        }
        
        // 2. do dfs search from start
        return dfs(graph, start, end, new HashSet<>());

    }
    
    public boolean dfs(Map<Integer, List<Integer>> graph, int start, int end, Set<Integer> visited) {
        
        // prevent getting stuck in infinite loop
        visited.add(start);
        
        // base case - if destination is found
        if (start == end) {
            return true;
        }
        
        List<Integer> neighbors = graph.get(start);
        for (int cur : neighbors) {
            if (!visited.contains(cur)) {
                if (dfs(graph, cur, end, visited)) {
                    return true;
                }
            }
        }
        
        // return false if end vertex is not reachable from start
        return false;  
    }
}