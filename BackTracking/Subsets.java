package BackTracking;

/*
backtracking
constraints: length of the subset
important nort is this solution is orgnized based on the length of the subset
at first, length 0 subset, then length 1 subset, ... till length nums.length subset
*/
class Solution {
    
    List<List<Integer>> output = new ArrayList<>();
    int subsetLength;   // length of the subset
    
    public List<List<Integer>> subsets(int[] nums) {
        
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
            current.add(nums[i]);                   // 1. PICK
            backtracking(i + 1, nums, current);     // move with your choice
            current.remove(current.size() - 1);     // 2. DON'T PICK: remove the last choice
        }
        
    }
}
