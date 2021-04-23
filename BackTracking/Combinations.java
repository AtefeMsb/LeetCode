package BackTracking;

class Solution {
    class Solution {
    
        List<List<Integer>> result = new ArrayList<>();
        
        public List<List<Integer>> combine(int n, int k) {
            backtracking(1, new ArrayList<Integer>(), k, n);
            return result;
        }
        
        private void backtracking(int index, List<Integer> cur, int k, int n) {
            
            // base case - if the combination is done
            if (cur.size() == k) {
                result.add(new ArrayList<Integer>(cur));
                return;
            }
            
            // explore available choices
            for (int i = index; i <= n; i++) {
                cur.add(i);     // make a choice
                backtracking(i + 1, cur, k, n);
                cur.remove(cur.size() - 1);     // clean up
            }
        }
    }