class Solution {
    public int earliestAcq(int[][] logs, int n) {
        
        // 1. sort timestamps in increasing order
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        
        // 2. create a unionfind 
        UnionFind uf = new UnionFind(n);
        
        for (int[] log : logs) {
            uf.union(log[1], log[2]);
            // return the timestamp if all the item are in the same group
            if (uf.getCount() == 1) {
                return log[0];
            }
        }
        
        return -1;
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