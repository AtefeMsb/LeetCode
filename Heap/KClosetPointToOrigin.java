package Heap;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        // euclidean distance for point p o the origin p[0] * p[0] + p[1] * p[1]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.remove();
            }
        }
        
        int[][] result = new int[K][2];
        while (K-- > 0) {
            result[K] = maxHeap.remove();
        }
        
        return result;
    }
}
