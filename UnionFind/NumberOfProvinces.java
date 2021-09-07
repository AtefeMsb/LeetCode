/**
 * UnionFind
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();
    }

    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public boolean union(int A, int B) {
            int rootA = find(A);
            int rootB = find(B);
            // Check if A and B are already in the same set.(this means cycle was found)
            if (rootA == rootB) {
                return false;
            }
            if (rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
                rank[rootB] += rank[rootA];
            }
            else {
                root[rootB] = rootA;
                rank[rootA] += rank[rootB];
            }
            count--;
            return true;
        } 

        int getCount() {
            return count;
        }
    }
}
// ------------------------------------------