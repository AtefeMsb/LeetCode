package Heap;

class KthLargest {
    
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for (int num : nums) {
            pq.add(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        
        while (pq.size() > k) {
            pq.poll();
        }
        
        return pq.peek();
    }
}