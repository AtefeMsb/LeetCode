### Disjoint Set is used for:
1. finding cycle in undirected graph
2. Kruskal's Algorithm 

**A DSU data structure can be used to maintain knowledge of the connected components of a graph, and query for them quickly.**

In particular, we would like to support two operations:

- dsu.find(node x), which outputs a unique id so that two nodes have the same id if and only if they are in the same connected component, and:

- dsu.union(node x, node y), which draws an edge (x, y) in the graph, connecting the components with id find(x) and find(y) together.

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
}