package BackTracking;

class Solution {
    List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {

        this.backtrack(n, k, new LinkedList<Integer>(), 1);
        return results;
    }
    
    protected void backtrack(int remain, int k, LinkedList<Integer> cur, int next_start) {

        if (remain == 0 && cur.size() == k) {
            // Note: it's important to make a deep copy here,
            // Otherwise the combination would be reverted in other branch of backtracking. 
            results.add(new ArrayList<Integer>(cur));
            return;
        } else if (remain < 0 || cur.size() == k) {
            // Exceed the scope, no need to explore further.
            return;
        }

        // Iterate through the reduced list of candidates.
        for (int i = next_start; i < 10; ++i) {
            cur.add(i);
            this.backtrack(remain - i, k, cur, i + 1);
            cur.removeLast();
        }
    }
}
