package HashTable;

public class LRUCache {

    class DLinkedNode {
      int key;
      int value;
      DLinkedNode prev;
      DLinkedNode next;
    }
  
    private void addNode(DLinkedNode node) {
      /**
       * Always add the new node right after head.
       */
      node.prev = head;
      node.next = head.next;
  
      head.next.prev = node;
      head.next = node;
    }
  
    private void removeNode(DLinkedNode node){
      /**
       * Remove an existing node from the linked list.
       */
      DLinkedNode prev = node.prev;
      DLinkedNode next = node.next;
  
      prev.next = next;
      next.prev = prev;
    }
  
    private void moveToHead(DLinkedNode node){
      /**
       * Move certain node in between to the head.
       */
      removeNode(node);
      addNode(node);
    }
  
    private DLinkedNode popTail() {
      /**
       * Pop the current tail.
       */
      DLinkedNode res = tail.prev;
      removeNode(res);
      return res;
    }
  
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
  
    public LRUCache(int capacity) {
      this.size = 0;
      this.capacity = capacity;
  
      head = new DLinkedNode();
      // head.prev = null;
  
      tail = new DLinkedNode();
      // tail.next = null;
  
      head.next = tail;
      tail.prev = head;
    }
  
    public int get(int key) {
      DLinkedNode node = cache.get(key);
      if (node == null) return -1;
  
      // move the accessed node to the head;
      moveToHead(node);
  
      return node.value;
    }
  
    public void put(int key, int value) {
      DLinkedNode node = cache.get(key);
  
      if(node == null) {
        DLinkedNode newNode = new DLinkedNode();
        newNode.key = key;
        newNode.value = value;
  
        cache.put(key, newNode);
        addNode(newNode);
  
        ++size;
  
        if(size > capacity) {
          // pop the tail
          DLinkedNode tail = popTail();
          cache.remove(tail.key);
          --size;
        }
      } else {
        // update the value.
        node.value = value;
        moveToHead(node);
      }
    }
  }

  // --------------------------------------------------------------------------
  // simpler code
  class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        // dummy nodes
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node left;
    Node right;
     
    public LRUCache(int capacity) {
        this.capacity = capacity; 
        // left: LRU node
        // right: most recently used node
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;   
    }
    
    // remove a node from the list
    public void remove(Node cur) {
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
    }
    
    // insert a node at right (one before right)
    public void insert(Node cur) {
        Node prev = right.prev;
        Node next = right;
        prev.next = cur;
        cur.next = right;
        cur.prev = prev;
        right.prev = cur;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            remove(cur);
            insert(cur);
            return cur.val; 
        }
        
        return -1;     
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node cur = new Node(key, value);
        map.put(key, cur);
        insert(cur);
        
        // remove from the list and delete the lru from the hashmap
        if (map.size() > this.capacity) {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}