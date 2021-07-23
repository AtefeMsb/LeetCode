class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            
            // to avoid repetition of i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                
                // to avoid repetition of j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int sum1 = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    int sum = sum1 + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    
                        // to avoid repetition of left and right
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                        
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
     
                }
                
            }
        }

        return result;
    }
}