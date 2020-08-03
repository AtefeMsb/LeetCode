package AuguestChallenge2020;

import java.util.Arrays;

public class DesignHashSet {

	int[] set;
    
    /** Initialize your data structure here. */
    public DesignHashSet() {
       set = new int[1000001]; 
       Arrays.fill(set, -1);
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (set[key] == -1) {
            return false;
        }
        return true;
    }
}