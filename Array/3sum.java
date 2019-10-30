// a + b + c = 0
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            
            // avoiding duplicates in a by ignoring same numbers
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                // b + c = 0 - a
                int sum = 0 - nums[i];
                
                // using two-pointer technique
                while (low < high) {
                    // found a matching triplet
                    if (nums[low] + nums[high] == sum) {
                        results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // avoiding duplicates in b by ignoring same numbers
                        while (low < high && nums[low] == nums[low + 1]) low++; 
                        // avoiding duplicates in c by ignoring same numbers
                        while (low < high && nums[high] == nums[high - 1]) high--; 
                        low++;
                        high--;
                        // in case sum is not reached, adjust the boundries
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            } 
        }
        
        return results;
    }
}
