package Array;

class TwoSum3 {
    
    // key: number      value: frequency
    // the reson for keeping the frequency is for when key is the same as diff,
    // want to make sure we have more than one of the same item
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            int diff = value - key;

            if (map.containsKey(diff)) {
                if (diff == key  && val > 1) {
                    return true;
                } else if (diff != key) {
                    return true;
                }
            } 
        }
        
        return false;
    }
}