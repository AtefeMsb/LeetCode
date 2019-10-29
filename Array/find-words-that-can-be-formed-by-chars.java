class Solution {
    public int countCharacters(String[] words, String chars) {
        
        Map<Character, Integer> charsFreq = new HashMap<>();
        // count frequency of each character in string chars
        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            charsFreq.put(ch, charsFreq.getOrDefault(ch, 0) + 1);
        }
 
        int totalLength = 0;
        // analyze each word from words array at a time and compare it againts string chars
        for (String word : words) {
            System.out.println("word: " + word);
             // count frequency of each character in each word
            Map<Character, Integer> wordFreq = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                wordFreq.put(ch, wordFreq.getOrDefault(ch, 0) + 1);
            }
               
            // compare each char in word with same character frequencies in string chars, if frequency is less or equal for all the characters the word is a good word.
            boolean isGood = false;
            for (Map.Entry<Character, Integer> entry : wordFreq.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                
                if (charsFreq.containsKey(key) && (value <= charsFreq.get(key))) {
                    isGood = true;
                } else {
                    isGood = false;
                    break;
                }
                
            }
            
             if (isGood) {
                    totalLength += word.length();
                    System.out.println("new good word: " + word);
            }
            
        }
        
        return totalLength;
    }
}
