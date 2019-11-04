class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        // key: character, value: frequency
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.put(current, map.getOrDefault(current , 0) + 1);
        }
        
        // return index of first character with frequency of 1.
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map.get(current) == 1) {
                return i;
            }
        }   
        
        return -1;
    }
}
