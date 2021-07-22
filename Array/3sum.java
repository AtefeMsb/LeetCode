/**
 * using sorted list and two-pointers
 * time: O(n ^ 2)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        
        // sort - O(nlogn)
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            // avoid the duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            while (left < right) {
                
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // avoid the duplicate left and right
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
            
        }

        return result;
    }
}