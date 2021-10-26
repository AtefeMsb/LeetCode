class Solution {
    List<String> result = new ArrayList<>();
    // add them to the list in a sorted manner: a, e ,i ,o ,u
    List<Character> vowels = new ArrayList<>(Arrays.asList('a','e', 'i', 'o', 'u'));
    
    public int countVowelStrings(int n) {
        backtracking(n, 0, new StringBuilder());
        return result.size();
    }
    
    public void backtracking(int n, int start, StringBuilder cur) {
        
        // base case
        if (cur.length() == n) {
            String res = cur.toString();
            result.add(res);
            return;
        }
        
        // always pick vowels in order
        for (int i = start; i < vowels.size(); i++) {
            // choose
            cur.append(vowels.get(i));
            // backtrack
            backtracking(n, i, cur);
            // unchoose
            cur.deleteCharAt(cur.length() - 1);
        }
        
    }
}