/**
 * dfs
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int component = 0;
        
        // create and adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // start dfs from every unvisited node in the graph
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                component++;
                dfs(graph, visited, i);
            }
        }
        
        return component;  
    }
    
    public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node) {
        visited.add(node);
        for (int neigh : graph.get(node)) {
            if (!visited.contains(neigh)) {
                dfs(graph, visited, neigh);
            }
        }
    }
}
// -----------------------------------------------------------
/**
 * union find
 */
class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.isConnected(start, end);
        
    }
    
    class UnionFind {
        int[] rank;
        int[] root;
        
        public UnionFind(int size) {
            rank = new int[size];
            root = new int[size];
            
            for (int i = 0; i < size; i++) {
                rank[i] = 1;
                root[i] = i;
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    rank[rootX] += rank[rootY];
                    root[rootY] = rootX;
                } else {
                   rank[rootY] += rank[rootX];
                    root[rootX] = rootY; 
                }
            
            }
            
            return true;
        }
    }
}