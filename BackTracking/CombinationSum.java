class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        backtracking(candidates, target, new LinkedList<Integer>(), 0);
        return result;
    }
    
    private void backtracking(int[] candidates, int remainder, LinkedList<Integer> cur, int start) {
        
        if (remainder == 0) {
            result.add(new ArrayList<>(cur));
            return;
        } else if (remainder < 0) {
            return;
        }
        
        // always pick from the current i and the next ones, that is why the backtracking is start with i for the recurse
        for (int i = start; i < candidates.length; i++) {
            
            cur.add(candidates[i]);
            backtracking(candidates, remainder - candidates[i], cur, i);
            cur.removeLast();
        }   
    }
}