package HashTable;

// LinkedList as Bucket
class MyHDesignHashSetashSet {
    
    //  use a prime number as the base of modulo, e.g. 769, in order to reduce the potential collisions.
    private final int KEY_RANGE = 199;
    private final List<List<Integer>> parentList;

    /** Initialize your data structure here. */
    public MyHashSet() {
        parentList = new ArrayList<>(KEY_RANGE);
        // put null as each bucket
        for (int i = 0; i < KEY_RANGE; i++) {
            parentList.add(null);
        }
    }
    
    public void add(int key) {
        int index = hash(key);
        List<Integer> childList = parentList.get(index);
        if (childList == null) {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        } else {
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
        
    }
    
    public void remove(int key) {
        int index = hash(key);
        List<Integer> childList = parentList.get(index);
        if (childList != null) {
            childList.remove(Integer.valueOf(key));  
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> childList = parentList.get(index);
        return childList != null && childList.contains(key);
    }
    
    /** Generate the bucket number */
     private int hash(int n) {
        return n % KEY_RANGE;
    }
}

// LinkedList as Bucket
///////////////////////////////////////////////
class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;
  
    /** Initialize your data structure here. */
    public MyHashSet() {
      this.keyRange = 769;
      this.bucketArray = new Bucket[this.keyRange];
      for (int i = 0; i < this.keyRange; ++i)
        this.bucketArray[i] = new Bucket();
    }
  
    protected int _hash(int key) {
      return (key % this.keyRange);
    }
  
    public void add(int key) {
      int bucketIndex = this._hash(key);
      this.bucketArray[bucketIndex].insert(key);
    }
  
    public void remove(int key) {
      int bucketIndex = this._hash(key);
      this.bucketArray[bucketIndex].delete(key);
    }
  
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
      int bucketIndex = this._hash(key);
      return this.bucketArray[bucketIndex].exists(key);
    }
  }
  
  
  class Bucket {
    private LinkedList<Integer> container;
  
    public Bucket() {
      container = new LinkedList<Integer>();
    }
  
    public void insert(Integer key) {
      int index = this.container.indexOf(key);
      if (index == -1) {
        this.container.addFirst(key);
      }
    }
  
    public void delete(Integer key) {
      this.container.remove(key);
    }
  
    public boolean exists(Integer key) {
      int index = this.container.indexOf(key);
      return (index != -1);
    }
  }
  
  //Binary Search Tree (BST) as Bucket
  ///////////////////////////////////////////////////////
