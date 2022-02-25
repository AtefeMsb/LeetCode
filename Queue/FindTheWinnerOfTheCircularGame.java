class Solution {
    public int findTheWinner(int n, int k) {
        
        // 1. enqueue every person in the queue
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        while (queue.size() != 1) {
            // dequeue and enqueue the first 1 to k-1 person 
            for (int i = 1; i <= k - 1; i++) {
                int en = queue.remove();
                queue.add(en);
            }
            
            // dequeue the kth person
            queue.remove();
        }
        
        return queue.peek();
    }
}