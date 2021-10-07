// use of 4 pointers

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
    
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
          
                // avoding duplicates in i and j
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    
                int low = j + 1;
                int high = nums.length - 1;
                int diff = target - nums[i];
                
                while (low < high) {

                    int sum = nums[j] + nums[low] + nums[high];  
                
                    if (sum == diff) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        
                         // avoiding duplicates in low and high
                        while (low < high && nums[low] == nums[low + 1]) low++; 
                        while (low < high && nums[high] == nums[high - 1]) high--; 
                        
                        low++;
                        high--;
                    } else if (sum < diff) {
                        low++;
                    } else {
                        high--;
                    }
                }
                
            }
        }

       return results; 
    }
}
