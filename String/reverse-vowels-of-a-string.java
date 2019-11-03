// A, E, I, O, U
class Solution {
    public String reverseVowels(String s) {
        
        // put wovels in a set
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        int len = s.length();
        // convert to char array
        char[] charArr = s.toCharArray();
        
        int low = 0;
        int high = len - 1;
        
        while (low < high) {
                       
            // get low index to a vowel char
            while (low < high && !vowelsSet.contains(Character.toLowerCase(charArr[low]))) {
                low++;
            }
            
            // get high index to a vowel char
            while (low < high && !vowelsSet.contains(Character.toLowerCase(charArr[high]))) {
                high--;
            }
            
            if (low < high) {
                char tmp = charArr[low];
                charArr[low] = charArr[high];
                charArr[high] = tmp;
                low++;
                high--;
            }
        
        } // while
        
        // convert char array to string
        return new String(charArr);
    }
}
