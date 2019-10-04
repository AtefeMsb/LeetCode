// using map
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i< nums.length; i++) {
            if (freqMap.containsKey(nums[i])) {
                return true;
            }
            freqMap.put(nums[i], 1);
        }
        
        return false;
    }
}


// using set
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;   
   }          
}
