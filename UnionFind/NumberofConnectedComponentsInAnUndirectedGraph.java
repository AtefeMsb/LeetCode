/**
 * dfs
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.getCount();
    
    }
    
    class UnionFind {
        
        int[] root;
        int[] rank;
        int count;
        
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
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
                    root[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                } else {
                    root[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                } 
                count--;
            }
            
            return true;
        }
        
        public int getCount() {
            return count;
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