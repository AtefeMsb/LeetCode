class TwoSum {
    
    // key: number      value: frequency
    Map<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {
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
