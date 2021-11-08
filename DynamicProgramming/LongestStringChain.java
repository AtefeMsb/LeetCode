/**
 * memoization
 * Let N be the number of words in the list and L be the maximum possible length of a word.
 * Time complexity: O(L ^ 2 *  N)
 */

class Solution {

    public int longestStrChain(String[] words) {
        
        Map<String, Integer> memo = new HashMap<>();
        
        Set<String> wordsPresent = new HashSet<>();
        for (String word : words) {
            wordsPresent.add(word);
        }
        
        // find the maxium sequence that ENDS WITH this word
        for (String word : words) {
            memoization(wordsPresent, word, memo);
        }
        
        // pick the largest value as the result
        int result = 0;
        for (int val : memo.values()) {
            result = Math.max(result, val);
        }
        return result;
    }
    
    private int memoization(Set<String> words, String currentWord,  Map<String, Integer> memo) {
        
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }
        
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);

        // creating all possible strings taking out one character at a time from the `currentWord`
        for (int i = 0; i < currentWord.length(); i++) {
            
            // delete the character
            sb.deleteCharAt(i);
            
            String newWord = sb.toString();
            // If the new word formed is present in the list, we do a dfs search with this newWord.
            if (words.contains(newWord)) {
                int currentLength = 1 + memoization(words, newWord, memo);
                maxLength = Math.max(maxLength, currentLength);
            }
            
            // put the deleted character back
            sb.insert(i, currentWord.charAt(i));
            
        }
        
        memo.put(currentWord, maxLength);
        return maxLength;
    }
}

// --------------------------------
/**
 * dynamic programming
 * time: O(N.logN + N.L^2)
 */
class Solution {
    public int longestStrChain(String[] words) {
        
        // key: word    value: the longest sequence length that ends with this word
        Map<String, Integer> dp = new HashMap<>();
        
        // O(NlogN)
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int result = 0;
        // O(N.L^2)
        for (String word : words) {
            
            int currentLength = 1;
            
            // O(L^2)
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                // remove character at index i
                // O(L)
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int predecessorLength = dp.getOrDefault(predecessor, 0);
                currentLength = Math.max(currentLength, 1 + predecessorLength);
            }
            
            dp.put(word, currentLength);
            result = Math.max(result, currentLength);
        }
      
        return result;
    }
}