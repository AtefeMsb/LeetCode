class Solution {
    public int compress(char[] chars) {
        
        // to keep location of insert in the chars array
        int index = 0;
        
        // to find the head of the groups
        int i = 0;
        
        while (i < chars.length) {
            int j = i;
            
            // find the end of the current group
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            
            chars[index] = chars[i];
            index++;
                  
            // only add compression pharase for counts more than 1
            if (j - i > 1) {
                String count = j - i + "";
                for (char c : count.toCharArray()) {
                    chars[index] = c;
                    index++;
                }
                
            }
            
            // move i to j location, to begin a new group of characters
            i = j;
              
        }
        
        return index;
        
    }
}