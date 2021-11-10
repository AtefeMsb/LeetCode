class MedianFinder {
    // keeps the smallest half 
    PriorityQueue<Integer> maxHeap;
    // keeps the largest half 
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        minHeap = new PriorityQueue<>();
    }
    
    // O(logn) for add and remove to the heap
    public void addNum(int num) {
        
        // 1. add num to maxHeap
        maxHeap.add(num);
        
        // 2. make sure every number in maxHeap is <= every number at minHeap
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.remove());
        }
        
        // 3. find the uneven size (one of the heaps is larger in size than the other more than 1)
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }
        
         if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.remove());
        }
        
    }
    
    // O(1) he tops of heaps are directly accessible
    public double findMedian() {
        
        // if the count of numbers is odd
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        
         if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        
        // if the count of numbers is even
        return (double)(maxHeap.peek() + minHeap.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */