class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> map  = new HashMap<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        // fill out the map with all the frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        backtracking(nums, new ArrayList<>());
        return result;
    }
    
    public void backtracking(int[] nums, List<Integer> cur) {
        // base case - a permutation was found
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
    
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                // 1.choose
                cur.add(key);
                map.put(key, map.get(key) - 1);
                
                // 2.recurse
                backtracking(nums, cur);
                map.put(key, map.get(key) + 1);
                
                // 3.unchoose
                cur.remove(cur.size() - 1);
                
            }   
            
        }
        
    }
}