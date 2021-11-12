// TreeMap to have an ordered map
class SnapshotArray {
    int snapId;
    List<TreeMap<Integer, Integer>> list;
    
    public SnapshotArray(int length) {
        snapId = 0;
        
        list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new TreeMap<Integer, Integer>());
            list.get(i).put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        list.get(index).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        // Returns a key-value mapping associated with the greatest key less than or equal to the given key,
        // or null if there is no such key.
        return list.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */