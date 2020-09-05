package SeptemberChallenge2020;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        
        Map<Character, Integer> lastOccurrences = new HashMap<>();
        List<Integer> result = new ArrayList<>();
          
        // create the map containg last occurence of each character
        for (int i = 0; i < S.length(); i++) {
            lastOccurrences.put(S.charAt(i), i); 
        }
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            
            end = Math.max(end, lastOccurrences.get(S.charAt(i)));
    
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
            
        }
                
        return result;
    }
}