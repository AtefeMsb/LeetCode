class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // role 1: first differing character
        // role 2: if word A is prefix of word B, word B must be after word A
        
        // put the order of each alphabet in a map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            
            // each pair of word next to each other
            String w1 = words[i];
            String w2 = words[i + 1];
            
            for (int j = 0; j < w1.length(); j++) {
                // if reach the end of w2, means w2 is prefix of w1
                if (j == w2.length()) {
                    return false;
                }
                
                // first differing character
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (map.get(w1.charAt(j)) > map.get(w2.charAt(j))) {
                        return false;
                    }
                    break;
                }
            }
        }
        
        return true;
    }
}