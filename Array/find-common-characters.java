/*
integer array (minFrequencies): minimum frequency of each character through ALL the strings
integer array (charFrequencies): charchter frequency of each character in each string
*/
class Solution {
    public List<String> commonChars(String[] A) {
        
        List<String> result = new ArrayList();
        
        int[] minFrequencies = new int[26];
        Arrays.fill(minFrequencies, Integer.MAX_VALUE);
        
        for (String str : A ) {
            
            int[] charFrequencies = new int[26];
            
            // counting frequency of each character in this string
            for (char c : str.toCharArray()) {
                // each index is for a char ex: a is at index 0, z is at index 25
                charFrequencies[c - 'a']++;
            }
    
            // compare frequency of each character in this string with total min frequency of all characters and pick the min
            for (int i = 0; i < 26; i++) {
                minFrequencies[i] = Math.min(minFrequencies[i], charFrequencies[i]);
            }
            
        }
        
        // loop through the minFrequencies array and add each character to the result
        for (int i = 0; i < 26; i++) {
            while (minFrequencies[i] > 0) {
                result.add("" + (char)(i + 'a'));
                minFrequencies[i]--;
            }
        }
        
        return result;
    }
}
