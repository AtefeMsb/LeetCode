package TwoPointers;

class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> partionLengths = new ArrayList<>();
        
        // create a list of last occurence of each character
        int[] lastIndices = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndices[S.charAt(i) - 'a'] = i;
        }
                
        int i = 0;
        while (i < S.length()) {
            int end = lastIndices[S.charAt(i) - 'a'];
            
            int j = i;
            while (j < end) {
                end = Math.max(end, lastIndices[S.charAt(j) - 'a']);
                j++;
            }
            
            int length = j - i + 1;
            partionLengths.add(length);
            i = j + 1;
        }
        
        return partionLengths;
    }
}