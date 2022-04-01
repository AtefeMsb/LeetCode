// HashSet
class SparseVector {
    
    Map<Integer, Integer> map;
    
    public SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for (int i : map.keySet()) {
            if (vec.map.containsKey(i)) {
                res += map.get(i) * vec.map.get(i);
            }
        }
        
        return res;
    }
}
// ---------------------------------------------------------
// index-value pairs
class SparseVector {
    
    List<int[]> list;
    
    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new int[]{i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int p = 0;
        int q = 0;
        int res = 0;
        
        while (p < this.list.size() && q < vec.list.size()) {
            if (this.list.get(p)[0] == vec.list.get(q)[0]) {
                res += this.list.get(p)[1] * vec.list.get(q)[1];
                p++;
                q++;
            } else if (this.list.get(p)[0] > vec.list.get(q)[0]) {
                q++;
            } else {
                p++;
            }
        }
        
        return res;
    }
}