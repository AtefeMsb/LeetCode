// Two Queues -- push O(1), pop O(n)
/*
class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;
    
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
        top = x;
    }
    
    public int pop() {
        int theTop = top;
        while (q1.size() > 1) {
            top = q1.poll();
            q2.add(top);
        }
        
        q1.poll();
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return theTop;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
*/
    
// One Queues -- push O(n), pop O(1)
class MyStack {

    private Queue<Integer> q;
 
    
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while (size > 1) {
            q.offer(q.poll());
            size--;
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}
