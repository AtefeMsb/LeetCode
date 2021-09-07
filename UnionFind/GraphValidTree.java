/**
 * UnionFind
 */
class UnionFind {
    
    private int[] parent;
    private int[] size; 
    
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
            size[node] = 1;
        }
    }
    
     public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
    }


    public boolean union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);
        // Check if A and B are already in the same set.(this means cycle was found)
        if (rootA == rootB) {
            return false;
        }
        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        return true;
    } 
}

class Solution {
    
    public boolean validTree(int n, int[][] edges) {
        
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) return false;
        
        // Condition 2: The graph must contain a single connected component.
        // Create a new UnionFind object with n nodes. 
        UnionFind unionFind = new UnionFind(n);
        // Add each edge. Check if a merge happened, because if it 
        // didn't, there must be a cycle.
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!unionFind.union(A, B)) {
                return false;
            }
        }
        
        // If we got this far, there's no cycles!
        return true;
    }
    
}
// -------------------------------------------------------
/**
 * FIND A CYCLE IN AN UNDIRECTED GRAPH USING DFS
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        // if number of edges is less or more than n - 1, this graph is not a tree.
        if (edges.length != n - 1) return false;
        // empty graph is a tree
        if (n == 0) return true;
        
        // create adjacency list
        Map<Integer, List<Integer>> list = new HashMap<>();
        for (int i = 0; i < n; i++) {
            list.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        // The graph is a tree if: 
        // 1. it has no cycle
        // 2. the graph is connected, all the nodes have been visited (visited.size() == n)
        return !hasCycle(list, visited, 0, -1) && visited.size() == n;
    
    }
    
    // dfs - finds out cycle in the graph
    private boolean hasCycle(Map<Integer, List<Integer>> list, Set<Integer> visited,  int node, int prev) {
        
        if (visited.contains(node)) return true;
        visited.add(node);
        
        for (int neighbor : list.get(node)) {
            if (neighbor == prev) continue;
            if (hasCycle(list, visited, neighbor, node)) {
                return true;
            }
        }
        
        return false;
    }
}