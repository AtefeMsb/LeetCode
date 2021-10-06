/**
 * HashMap: Hashmap provides Insert and Delete in average constant time, although has problems with GetRandom.
 * The idea of GetRandom is to choose a random index and then to retrieve an element with that index. There is no indexes in hashmap,
 * and hence to get true random value, one has first to convert hashmap keys in a list, that would take linear time. The solution here
 * is to build a list of keys aside and to use this list to compute GetRandom in constant time.
 * 
 * Array: Array List has indexes and could provide Insert and GetRandom in average constant time, though has problems with Delete.
 * To delete a value at arbitrary index takes linear time. The solution here is to always delete the last value:
        - Swap the element to delete with the last one.
        - Pop the last element out.
    For that, one has to compute an index of each element in constant time, and hence needs a hashmap which stores element -> its index dictionary.

* Both ways converge into the same combination of data structures:
    - Hashmap element -> its index.
    - Array List of elements.
 */
class RandomizedSet {
    // key: val    value: index
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        // move the lastElement to the place of indexToRemove
        int indexToRemove = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(indexToRemove, lastElement);
        map.put(lastElement, indexToRemove);
        // remove the last element from the list and map
        list.remove(list.size() - 1);
        map.remove(val);
        return true; 
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */