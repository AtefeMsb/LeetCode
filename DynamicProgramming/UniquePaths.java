/**
 * dynamic programming with memoization
 * time: O(m * n)
 * space: O(m + n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        return travelingMemoization(m, n, new HashMap<>());
    }
    
    private int travelingMemoization(int m, int n, Map<String, Integer> memo) {
        
        // calculate the key for memo object
        String key = m + "," + n;
        
        // check the memo
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // base case 
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        
        memo.put(key, travelingMemoization(m - 1, n, memo) + travelingMemoization(m, n - 1, memo));
        return memo.get(key);
    }
}
// --------------------------------------------
/**
 * dynamic programming with tabulation
 * time: O(m * n)
 * space: O(m * n)
 * time: O(m * n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                table[i][j] = 0;
            }
        }
        
        // base case - grid of size 1 * 1 has 1 way to be traveled
        table[1][1] = 1;
        
        // each item gets added to the square on the right and the one on its bottom
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int current = table[i][j];
                
                if (i + 1 <= m) table[i + 1][j] += current; // down neighbord
                if (j + 1 <= n) table[i][j + 1] += current; // right neighbor
            }
        }
        
        return table[m][n];
        
    }
}