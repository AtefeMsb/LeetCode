package BackTracking;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> current = new LinkedList<Integer>();
        
        findCombinations(candidates, target, 0, current, result);
        
        return result;
    }
    
    // this function is backtracking. basically is DFS using recursion to find all the combinations
    private void findCombinations(int[] candidates, int target, int index, LinkedList<Integer> current, List<List<Integer>> result) {
        
        // got all the number we wanted
        if (target == 0) {
            // make a deep copy of the current combination
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        
        // exceed the target, no more candidate can solve this because they all are positive
        if (target < 0) {
            return;
        }
        
        // this is the matter of taking or not taking a number
        for (int i = index; i < candidates.length; i++) {
            
            // add the number into the combination
            current.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i , current, result);
            
             // backtrack, remove the number from the combination
            current.removeLast();
            
        }
 
    }
    
}