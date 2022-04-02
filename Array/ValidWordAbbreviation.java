class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        int i = 0;
        int j = 0;
        
        while (i < word.length() && j < abbr.length()) {
            
            // skip over similar characters
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            
            // the first non-similar character should be digit and non-zero
            if (!Character.isDigit(abbr.charAt(j)) || abbr.charAt(j) == '0') {
                return false;
            }
            
            // find the number
            int start = j;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                j++;
            }
            
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
           
        }
        
        return i == word.length() && j == abbr.length();
    }
}
