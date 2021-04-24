package BackTracking;

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        backtracking(new ArrayList<Integer>(), nums);
        return result;
        
    }
    
    private void backtracking(List<Integer> cur, int[] nums) {
        
        // base case - when the length of the permutation is equal length of nums
        if (cur.size() == nums.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        // iterate all possible candidates
        for (int i = 0; i < nums.length; i++) {
            
            int choice = nums[i];
            
            // if this num already exists, skip it
            if (cur.contains(nums[i])) continue;
            
            // 1. choose
            cur.add(nums[i]);
            
            // 2. explore - recurse on the choice
            backtracking(cur, nums);
            
            // 3. unchoose - We have returned from the recursion, remove the choice we made.
            // The next iteration will try another item in the "slot" we are working on.  
            cur.remove(cur.size() - 1);
        }
    }
}
