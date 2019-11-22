class Solution {
    public int numJewelsInStones(String J, String S) {
        
        int result = 0;
        
        Set<Character> jewels = new HashSet<>();
        for (char ch : J.toCharArray()) {
            jewels.add(ch);
        }
        
        for (char ch : S.toCharArray()) {
            if (jewels.contains(ch)) {
                result++;
            }
        }
        
        return result;
    }
}
