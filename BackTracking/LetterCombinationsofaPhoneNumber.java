package BackTracking;

class Solution {
    
    List<String> result = new ArrayList<>();
     private Map<Character, String> letters = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl", 
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        // empty string
        if (digits.length() == 0) {
            return result;
        } 
        backtracking(0, new StringBuilder(), digits);
        return result;
    }
    
    private void backtracking(int index, StringBuilder path, String digits) {
        
        // base case - when the combination length is the same as length of digits
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        
        // what are the possible letters for this index
        String possibleLetter = letters.get(digits.charAt(index));
        for (char c : possibleLetter.toCharArray()) {
            path.append(c);                         // make a choice
            backtracking(index + 1, path, digits);  // backtrack for the next index
            path.deleteCharAt(path.length() - 1);   // remove the last choice
        }
        
    }
}