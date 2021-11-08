class Solution {
    List<List<String>> result = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> postiveDiagnal = new HashSet<>();  // r + c
    Set<Integer> negativeDiagnal = new HashSet<>(); // r - c
    
    public List<List<String>> solveNQueens(int n) {
        
        // create an empty board
        char[][] current = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                current[i][j] = '.';
            }
        }
        
        backtracking(0, current, n);
        return result; 
    }
    
    // utility function to convert a 2d array of character into list<String>
    public List<String> util(char[][] current, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                temp.append(current[i][j]);
            }
            result.add(temp.toString());
        }
        return result;
    }
    
    
    public void backtracking(int row, char[][] current, int n) {
        
        // found one possible answer
        if (row == n) {
            result.add(util(current, n));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            
            // condition
            if (cols.contains(col) || postiveDiagnal.contains(row + col) || negativeDiagnal.contains(row - col)) {
                continue;
            }
            
            // choose
            cols.add(col);
            postiveDiagnal.add(row + col);
            negativeDiagnal.add(row - col);
            current[row][col] = 'Q';
            
            
            // backtrack to next row
            backtracking(row + 1, current, n);
            
            // unchoose
            cols.remove(col);
            postiveDiagnal.remove(row + col);
            negativeDiagnal.remove(row - col);
            current[row][col] = '.';
            
        }
        
    }
}