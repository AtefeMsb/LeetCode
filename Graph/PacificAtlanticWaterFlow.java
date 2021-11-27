/**
 * intuition: start from the boarders and run dfs to reach all the reachable cells
 */
class Solution {
    int n;
    int m;
    int[][] heights;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.n = heights.length;
        this.m = heights[0].length;
        this.heights = heights;
        
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();
        
        // dfs from every cell in first row and last row
        for (int c = 0; c < m; c++) {
            // first row
            dfs(0, c, pacific, heights[0][c]); 
            // last row
            dfs(n - 1, c, atlantic, heights[n - 1][c]);
        }
        
        // dfs from every cell in first col and last col
        for (int r = 0; r < n; r++) {
            // first col
            dfs(r, 0, pacific, heights[r][0]); 
            // last col
            dfs(r, m - 1, atlantic, heights[r][m - 1]);
        }
        
        // save the cells that exists in pacific and atlantic set
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String key = i + "-" + j;
                if (pacific.contains(key) && atlantic.contains(key)) {
                    result.add(Arrays.asList(i, j));
                }
                
            }
        }
        
        return result;
    }
    
    public void dfs(int r, int c, Set<String> visited, int previousVal) {
        
        String key = r + "-" + c;
        if (visited.contains(key) || r < 0 || c < 0 || r >= n || c >= m || previousVal > heights[r][c]) {
            return;
        }
        visited.add(key);
        dfs(r + 1, c, visited, heights[r][c]);
        dfs(r - 1, c, visited, heights[r][c]);
        dfs(r, c + 1, visited, heights[r][c]);
        dfs(r, c - 1, visited, heights[r][c]);
        
    }
}