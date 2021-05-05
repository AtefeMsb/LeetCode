/*
Kruskal’s Algorithm:

Initialize an empty edge set T. 
Sort all graph edges by the ascending order of their weight values. 
foreach edge in the sorted edge list
    Check whether it will create a cycle with the edges inside T.
    If the edge doesn't introduce any cycles, add it into T. 
    If T has (V-1) edges, exit the loop. 
return T
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        // number of vertices
        int n = points.length;
        int ans = 0;
        
        // minheap based on the first value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        // save all the destinations in a minheap
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                // [distance, src, dest]
                pq.add(new int[]{ findDist(points, i, j), i, j });
            }
        }
        
        // number of edges
        int count = 0;
        
        UnionFind uf = new UnionFind(n);
        
        // while number of edges in NOT EQUAL (n - 1)
        while(count < n-1) {
            // pick the shortest destination
            int[] edge = pq.poll();
            // if this edge doesn't cause a cycle, add it
            if(uf.find(edge[1]) != uf.find(edge[2])) {
                ans += edge[0];
                count++;
                uf.union(edge[1], edge[2]);
            }
        }
        return ans;
    }
    
    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
    
    class UnionFind {   
        int[] parent;
        UnionFind(int n) {
            this.parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }		
        public void union(int a, int b) {
            parent[find(a)] = parent[find(b)];
        }
        public int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}