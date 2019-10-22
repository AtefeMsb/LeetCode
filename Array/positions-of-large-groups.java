/*
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        int startIndex = 0;
        
        for (int i = 0; i <= S.length(); i++) {
            
            // new group or last element
            if (i == S.length() || S.charAt(i) != S.charAt(startIndex)) {
                
                // add the group to the array if lenght >= 3
                if (i - startIndex >= 3) {
                    results.add(Arrays.asList(startIndex, i - 1));
                
                }   
                startIndex = i;
            }
        }
        
        return results;

    }
}
*/

// Two Pointers
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        int length = S.length();
        int i = 0;
       
            for (int j = i; j < length; j++) {
                if (j == length - 1 || S.charAt(j) != S.charAt(j + 1)) {
                    if (j - i + 1 >= 3) {
                    results.add(Arrays.asList(i, j));
                    }
                    i = j + 1;
                }
            }
        return results;
    }
}
