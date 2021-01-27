package HashTable;

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
  }
}

class DesignHashMap {
    
    private final int KEY_RANGE = 199;
    private final List<List<Pair<Integer, Integer>>> parentList;

    /** Initialize your data structure here. */
    public MyHashMap() {
        parentList = new ArrayList<>(KEY_RANGE);
        // put null as each bucket
        for (int i = 0; i < KEY_RANGE; i++) {
            parentList.add(null);
        }
    }
    
     /** Generate the bucket number */
     private int hash(int n) {
        return n % KEY_RANGE;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        List<Pair<Integer, Integer>> childList = parentList.get(index);
        // no pair in this index
        if (childList == null) {
            List<Pair<Integer, Integer>> list = new LinkedList<>();
            list.add(new Pair<Integer, Integer>(key, value));
            parentList.set(index, list);
        } else {
            boolean found = false;
            for (Pair<Integer, Integer> pair : childList) {
                // if key already exist, only update it
                if (pair.first.equals(key)) {
                    pair.second = value;
                    found = true;
                }
            }
            
            if (found == false) {
                childList.add(new Pair<Integer, Integer>(key, value));
            }
            
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        List<Pair<Integer, Integer>> childList = parentList.get(index);
        if (childList != null) {
            for (Pair<Integer, Integer> pair : childList) {
            if (pair.first.equals(key))
                return pair.second;
             }   
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        List<Pair<Integer, Integer>> childList = parentList.get(index);
        if (childList != null) {
            for (Pair<Integer, Integer> pair : childList) {
                if (pair.first.equals(key)) {
                childList.remove(pair);
                 break;
            }
        }
                
    }
}
        
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */