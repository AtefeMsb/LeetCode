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
