class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        
        if (words.length != chars.length) return false;
        
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            String word = words[i];
            
            if (map1.containsKey(ch) && !map1.get(ch).equals(word)) {
                return false;
            } else if (map2.containsKey(word) && !map2.get(word).equals(ch)) {
                return false;
            } else {
                map1.put(ch, word);
                map2.put(word, ch);
            }
        }
        
        return true;
    }
}