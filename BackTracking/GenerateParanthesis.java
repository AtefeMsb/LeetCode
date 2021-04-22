package BackTracking;

/*
backtracking
3 keys
choice: place a "(" or ")"
constraints: we can not close until open
goal: n*2 placements
*/
class Solution {
    List<String> output = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder(), n);
        return output;
    }
    
    private void backtrack(int openLeft, int closeLeft, StringBuilder current, int max) {
        
        // base case  
        if (current.length() == max * 2) {
            output.add(current.toString());
            return;
        }
        
        // if open bracket left to add, add "("
        if (openLeft > 0) {
            current.append("(");
            backtrack(openLeft - 1, closeLeft, current, max);
            current.deleteCharAt(current.length() - 1);
        }
        
        // if there are some open bracket that has not been closed, add ")"
         if (openLeft < closeLeft) {
            current.append(")");
            backtrack(openLeft, closeLeft - 1, current, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}