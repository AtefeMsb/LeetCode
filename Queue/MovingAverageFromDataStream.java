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
second way: keeping the size of queue less or equal the size
keeping the updated total sum
 */

class MovingAverage2 {

    int size, windowSum = 0, count = 0;
    Deque<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<Integer>();
    }

    public double next(int val) {
    ++count;

    // calculate the new sum by shifting the window
    queue.add(val);
    int tail = (count > size) ? (int)queue.poll() : 0;

    windowSum = windowSum - tail + val;

    return windowSum * 1.0 / Math.min(size, count);\
        
    }
}