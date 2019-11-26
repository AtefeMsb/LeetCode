class MovingAverage {

    private Queue<Integer> queue;
    private int maxSize;
    private double sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        maxSize = size;
        sum = 0.0;
    }
    
    public double next(int val) {
        if (queue.size() == maxSize) {
            // remove one item from head
            sum = sum - queue.poll();
        }
        
        queue.offer(val);
        sum += val;
        return sum / queue.size(); 
        
    }
}
