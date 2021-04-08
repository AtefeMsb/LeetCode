package UnionFind;

class Solution {
   
    public int[] findRedundantConnection(int[][] edges) {
        
        DSU dsu = new DSU(edges.length + 1);
        
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }
        
        return new int[2];
        
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        // Find the root of the component
        int root = x;
        while (root != parent[root]) root = parent[root];
        
        // Compress the path leading back to the root
        while (x != root) {
            int next = parent[x];
            parent[x] = root;
            x = next;
        }

        return root;
    }

    public boolean union(int x, int y) {
        
        int root1 = find(x);
        int root2 = find(y);
        
        if (root1 == root2) {
            return false;
        } else if (rank[root1] < rank[root2]) {
            rank[root2] += rank[root1];
            parent[root1] = root2;
        } else {
            rank[root1] += rank[root2];
            parent[root2] = root1;
        }
            
        return true;
    }
}
