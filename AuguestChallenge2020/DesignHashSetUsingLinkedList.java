package AuguestChallenge2020;

import java.util.LinkedList;

public class DesignHashSetUsingLinkedList {

    private Bucket[] bucketArray;
    private int range;

    /** Initialize your data structure here. */
    public DesignHashSetUsingLinkedList() {
        this.range = 769;
        this.bucketArray = new Bucket[this.range];
        
        for (int i = 0; i < this.range; i++) {
            bucketArray[i] = new Bucket();
        }
    }
    
    protected int _hash(int key) {
        return (key % this.range);
    }
    
    public void add(int key) {
        int hashValue = _hash(key);
        this.bucketArray[hashValue].insert(key);
        
    }
    
    public void remove(int key) {
        int hashValue = _hash(key);
        this.bucketArray[hashValue].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashValue = _hash(key);
        return this.bucketArray[hashValue].exists(key);
    }
}



class Bucket {
  private LinkedList<Integer> container;
    
  public Bucket() {
      container = new LinkedList<Integer>();
  }  
    
  public void insert(Integer key) {
      int index = container.indexOf(key);
      if (index == -1) {
          this.container.addFirst(key);
      }
  } 
  public void delete(Integer key) {
      this.container.remove(key);
      
  }
  public boolean exists(Integer key) {
      int index = container.indexOf(key);
      return (index != -1); 
  } 
  
}
    
}