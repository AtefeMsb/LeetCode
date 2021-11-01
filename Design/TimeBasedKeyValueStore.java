/**
 * Binary Search
 */

class Pair {
    String value;
    int timestamp;
    
    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair>());
        }
        
        map.get(key).add(new Pair(value, timestamp));  
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> list = map.get(key);
        return findClosetValue(list, timestamp);
    }
    
    // BInary Search
    public String findClosetValue(List<Pair> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            // to avoid infite loop
            int mid = (left + right + 1) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }  
        }
        
        Pair closet = list.get(left);
        return closet.timestamp > timestamp ? "" : closet.value; 
    }
}
