package DynamicProgramming;

/**
* DYNAMIC IMPLEMENATION
* USING MEMOIZATION

* n = String S length
* Time Complexity: O(n ^ 3) (recursion, for loop, substring)
* Space Complexity: O(n)
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return memoization(s, new HashSet<>(wordDict), 0, new HashMap<Integer,Boolean>());
    }
    
    private boolean memoization(String s, Set<String> wordDict, int start, HashMap<Integer,Boolean> memo) {
        
        // base case
        if (start == s.length()) {
            return true;
        }
        
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        // we need 2 pointers for substring: start, end
        for (int end = start + 1; end <= s.length(); end++) {
            
            // substring from start to end (not including) exists in the dictionary &&
            // memoization for the substring from end to the end returns true
            if (wordDict.contains(s.substring(start, end)) && memoization(s, wordDict, end, memo)) {
                memo.put(start, true);
                return true;
            }
        }
        memo.put(start, false);
        return false;   
    }
}
// ===============================================================================================
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return wb(s, dict, new HashMap<>());
    }
    
    private boolean wb(String s, Set<String> dict, Map<String, Boolean> memo) {
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        if (s.length() == 0) return true;
        
        // try all diffrent length
        for (int i = 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(0, i)) && wb(s.substring(i), dict, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;   
    }
}

// ===============================================================================================
/**
* DYNAMIC IMPLEMENATION
* USING TABULATUION

* n = String S length
* Time Complexity: O(n ^ 3) 
* Space Complexity: O(n)
*/
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        // i is the end pointer
        // j is the start pointer
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // if position j false, no need to continue
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}