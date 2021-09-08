/**
 * Union-find + PriorityQueue
 * Problem abstract: Sort the characters within each connected group.
 */
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() == 0) {
            return null;
        }
        
        // 1. For each the given pairs, create connected groups using union-find.
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        
        // 2. For each character in s, create mapping from root -> a list of candidate char.
        // Since we want to use the smallest one every time we pick from them, use PriorityQueue.
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            int root = uf.find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(sChar[i]);
        }
        
        // 3. Finally, for each index, choose the first char in the associated pq and append into result.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChar.length; i++) {
            sb.append(map.get(uf.find(i)).poll());
        }
        return sb.toString();
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