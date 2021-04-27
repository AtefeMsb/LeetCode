class Solution {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return memization(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> memization(String s, List<String> dictionary, Map<String, List<String>> memo) {
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
       
        List<String> result = new ArrayList<>();
        
        if (s.length() == 0) {
            // base case
            result.add("");
            return result;
        }
        
        // break the string apart and append the substring to the first word(s)
        for (String word : dictionary) {
            if (s.startsWith(word)) {
                List<String> restOfWords = memization(s.substring(word.length()), dictionary, memo);
                
                for (String str : restOfWords) {
                    String optionalSpace = str.isEmpty() ? "" : " ";
                    result.add(word + optionalSpace + str);
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
}
