package AuguestChallenge2020;

class GoatLatin {
    
    public String toGoatLatin(String S) {
        
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        StringBuilder goatS = new StringBuilder();
        String[] words = S.split(" ");
        int len = words.length;
        int index = 1;
        
        for (String word : words) {
                    
            // if first character is constant
            if (!vowels.contains(word.charAt(0))) {
                goatS.append(word.substring(1) + word.charAt(0));   
            } else {
                goatS.append(word); 
            }
            
            // add ma
            goatS.append("ma");
            
            // add a characters
            for (int i = 0; i < index; i++) {
                 goatS.append("a");
             }
            
            // add space - no space after last word
            if (index < len) {
                goatS.append(" ");
            }
            
            // move on the next words
            index++;
        }
        
     
        
        System.out.println(goatS);
        
        
        return goatS.toString();
    }
}