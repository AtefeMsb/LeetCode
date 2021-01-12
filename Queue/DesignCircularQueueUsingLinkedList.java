package Queue;

/*
Algorithm

Here we give a list of attributes in our circular queue data structure and the thoughts behind each attribute.

* capacity: the maximum number of elements that the circular queue will hold.
* head: the reference to the head element in the queue.
* count: the current length of the queue. This is a critical attribute that helps us to do the boundary check in each method.
* tail: the reference to the tail element in the queue. Unlike the Array approach, we need to explicitly keep the reference to the tail element.
 Without this attribute, it would take us O(N) time complexity to locate the tail element from the head element.
*/

class Node {
    public int value;
    public Node nextNode;
  
    public Node(int value) {
      this.value = value;
      this.nextNode = null;
    }
  }
  
  class MyCircularQueue {
  
    private Node head, tail;
    private int count;
    private int capacity;
  
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
      this.capacity = k;
    }
  
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
      if (this.count == this.capacity)
        return false;
  
      Node newNode = new Node(value);
      if (this.count == 0) {
        head = tail = newNode;
      } else {
        tail.nextNode = newNode;
        tail = newNode;
      }
      this.count += 1;
      return true;
    }
  
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
      if (this.count == 0)
        return false;
      this.head = this.head.nextNode;
      this.count -= 1;
      return true;
    }
  
    /** Get the front item from the queue. */
    public int Front() {
      if (this.count == 0)
        return -1;
      else
        return this.head.value;
    }
  
    /** Get the last item from the queue. */
    public int Rear() {
      if (this.count == 0)
        return -1;
      else
        return this.tail.value;
    }
  
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
      return (this.count == 0);
    }
  
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
      return (this.count == this.capacity);
    }
  }
