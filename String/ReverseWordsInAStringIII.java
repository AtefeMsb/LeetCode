class Solution {
    public String reverseWords(String s) {
        
        StringBuilder result = new StringBuilder();
        String[]  words = s.split(" ");
        
        // reverse each word
        for (int i = 0; i < words.length; i++) {
            String rev = reverse(words[i]);
            result.append(rev);
            
            // if it is not the last word, add an space after
            if (i < words.length - 1) {
                result.append(" ");
            }
            
        }
        
        return result.toString(); 
    }
    
    public String reverse(String s) {
        
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(chars);
    }
}