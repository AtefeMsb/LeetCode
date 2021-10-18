class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // to avoid duplicate combinations
        Arrays.sort(candidates);
        backtracking(candidates, target, new LinkedList<Integer>(), 0);
        return result;
        
    }
    
    public void backtracking(int[] candidates, int target, LinkedList<Integer> cur, int start) {
        
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        } else if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // if its the first or this number is not the same as last number
            if (i == start || candidates[i] != candidates[i - 1]) {
                // choose
                cur.add(candidates[i]);
                // backtrack
                backtracking(candidates, target - candidates[i], cur, i + 1);
                // unchoose
                cur.removeLast();
            }
             
        }
   
    }
}