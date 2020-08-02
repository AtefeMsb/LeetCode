package AuguestChallenge2020;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        
        boolean allCaps = true;
        boolean allLower = true;
        boolean camelCase = true;
        
        char[] chars = word.toCharArray();
        
        // all the letters are capital
        for (char letter : chars ) {
            if (Character.isLowerCase(letter)) {
                allCaps = false;
            }
        }
        
        if (allCaps) return true;
        
        // all the letter are lowercase
          for (char letter : chars ) {
            if (Character.isUpperCase(letter)) {
                allLower = false;
            }
        }
        
        if (allLower) return true;
        
        // only the first letter is capital
        if (Character.isLowerCase(chars[0])) {
            camelCase = false;
        }
        
        if (camelCase) {
        for (int i = 1; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                camelCase = false;
            }
        }
        }
    
        if (camelCase) return true;
        
        return false;
    }
}