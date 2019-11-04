class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        Set<String> transformations = new HashSet<>();
        int count = 0;
        
        String[] morseCodes = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        for (String word : words) {
            String newCode = "";
            for (char c : word.toCharArray()) {
                newCode += morseCodes[alphabet.indexOf(c)];
            }
            
            if (!transformations.contains(newCode)) {
                transformations.add(newCode);
                count++;
            }
        }
     return count;   
    }
}
