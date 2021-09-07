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