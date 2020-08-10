package Queue;

class MovingAverage {
    
    Queue<Integer> queue;
    int winSize;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque();
        winSize = size;
    }
    
    public double next(int val) {
        
        int sum = 0;
        queue.offer(val);
        
        // make sure to keep the size of queue less or equal than winSize
        while (queue.size() > winSize) {
            queue.poll();
        }
        
        
        for (int num : queue) {
           sum += num; 
        }
        
        return sum * 1.0 / Math.min(queue.size(), winSize);
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */