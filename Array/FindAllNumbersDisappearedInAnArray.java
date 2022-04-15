// space O(N)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
        
    }
}
// -----------------------------------------
// space: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        
        // check each number and mark and mark the value at the same index as negative
        // negative value is the indicator of that index being found
        for (int num : nums) {
            int index = Math.abs(num) - 1; 
            nums[index] = -1 * Math.abs(nums[index]);
            
        }
        
        // any non-negative value is missing from the list
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        
        return res;
        
    }
}