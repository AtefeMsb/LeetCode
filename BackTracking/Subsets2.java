package BackTracking;

class Solution {
    
    List<List<Integer>> output = new ArrayList<>();
    int subsetLength;   // length of the subset
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        // to avoid generating duplicates sort the nums, so duplicates item sits next to each other
        Arrays.sort(nums);
        
        // generate subsets in the order of their length
        for (subsetLength = 0; subsetLength <= nums.length; subsetLength++) {
            backtracking(0, nums, new ArrayList<Integer>());
        }

        return output;
    }
    
    private void backtracking(int first, int[] nums, List<Integer> current) {
        
        // base case - the current combination is done if reach the subsetLength
        if (current.size() == subsetLength) {
            output.add(new ArrayList<Integer>(current));
            System.out.println(current.toString());
            return;
        }
        
        // iterate over the indexes i from index to the length of the entire sequence n
        for (int i = first; i < nums.length; i++) {
            
            // avoid duplicate - because array is sorted so duplicates item sits next to each other
            if (i > first && nums[i] == nums[i - 1]) continue;
            
            current.add(nums[i]);                   // 1. PICK
            backtracking(i + 1, nums, current);     // move with your choice
            current.remove(current.size() - 1);     // 2. DON'T PICK: remove the last choice
        }
        
    }
}
