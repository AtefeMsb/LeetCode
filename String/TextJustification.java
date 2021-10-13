/**
* time: O(line * maxWidth)
* space: O(line * maxWidth)
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        while (i < n) {
            
            int j = i + 1;
            // only holds the length of characters (no spaces)
            int lineLength = words[i].length();
            // j - i - 1 : number of section for spaces (spaces between characters)
            while (j < n && (lineLength + words[j].length() + (j - i - 1)) < maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            
            // number of spaces in the line
            int diff = maxWidth - lineLength;
            int numberOfWords = j - i;
            
            // left justify if: (1) only one word in this line or (2) it is the last line
            if (numberOfWords == 1 || j >= n) {
                result.add(leftJustify(words, diff, i, j));
            } else {
                result.add(middleJustify(words, diff, i, j));
            }
         
            // move i to the j
            i = j;
        }
        
        return result;
    }
    
    private String leftJustify(String[] words, int diff, int i, int j) {
        int spacesOnRight = diff - (j - i - 1);
        
        // initialize with the first word
        StringBuilder sb = new StringBuilder(words[i]);
        
        for (int k = i + 1; k < j; k++) {
            sb.append(" " + words[k]);
        }
        
        sb.append(" ".repeat(spacesOnRight));
        
        return sb.toString();
    }
    
    private String middleJustify(String[] words, int diff, int i, int j) {
        int spacesSectionCount = j - i - 1;
        int spaces = diff / spacesSectionCount;
        int extraSpaces = diff % spacesSectionCount;
        
        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            // if there are extra, LEFT most words will get more spaces
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            sb.append(" ".repeat(spacesToApply) + words[k]);
        }
        
        return sb.toString();
    }
    
    
}