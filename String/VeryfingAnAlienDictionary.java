class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        // keep the index of each character in an array
        int[] alphabet = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alphabet[order.charAt(i) - 'a'] = i;
        }
        
        // compare each two words together
        for (int i = 0; i < words.length - 1; i++) {
         
            // minimum length of the two word
            int min = Math.min(words[i].length(), words[i + 1].length());
            
            for (int m = 0; m < min; m++) {
                int charI = words[i].charAt(m);
                int charJ = words[i + 1].charAt(m);
                if (alphabet[charI - 'a']  < alphabet[charJ - 'a']) {
                    break;
                } else if (alphabet[charI - 'a'] > alphabet[charJ - 'a']) {
                    return false;
                    // at the minimum and the shorter word is before longer word
                } else if (m == min - 1 && words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }
        }
        
        return true; 
    }
}