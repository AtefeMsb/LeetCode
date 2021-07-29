/**
* brute force - backtracking 
* time: O(n * 2 ^ n)
* space: O(n) for recursion stack
*/
class Solution {
    // public variables
    private String s;
    private List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        
        this.s = s;
        backtrack(0, new ArrayList<String>());
        return result;
        
    }
    
    // start: begining of the substring    
    // current: a list that holds all the paindrome substrings so far 
    private void backtrack(int start, List<String> current) {
        
        // base case - when start index is equal or more than the length of S
        if (start >= s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        }
        
        // try all possible substrings starting from start index
        for (int end = start; end < s.length(); end++) {
            // if the substring is a palindrome
            if (isPalindrome(start, end)) {
                // 1. choose
                // NOTE: substring end index is EXCLUSIVE
                current.add(s.substring(start, end + 1));
                // 2. explore
                backtrack(end + 1, current);
                // 3. unchoose
                current.remove(current.size() - 1); 
            }
             
        }  
    }
    
    // return true if substring [low, high] of S is palindrome
    private boolean isPalindrome(int low, int high) {
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}