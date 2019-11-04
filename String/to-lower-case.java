// lowercase char ascii number is 32 more than their uppercase.
class Solution {
    public String toLowerCase(String str) {
        
        String lowerCase = "";
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // if upper case char
            if (c >= 'A' && c <= 'Z') {
                int lowerCaseAscii = (int) c + 32;
                lowerCase += (char) lowerCaseAscii;
            } else {
                lowerCase += c;
            }
        }
        
        return lowerCase;
    }
}
