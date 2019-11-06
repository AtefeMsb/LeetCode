class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        Map<String, Integer> map = new HashMap<>();
        String mostCommonWord = "";
        int max = 0;
        
        // put all the banned words in a set
        Set<String> bannedSet = new HashSet<>();
        for (String word: banned) {
            bannedSet.add(word);
        } 
        
        // convert the whole paragraph to LOWERCASE and then split it
        // .split("[,!';?. ]+")
        // \\W A non-word character -- + means morethan one
        String[] words = paragraph.toLowerCase().split("\\W+");
                
        // frequency map for each NON-BANNED word 
        for (String word: words) {
            if (!bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        // check frequency each word in map
        for (String word: map.keySet()) {
            if(map.get(word) > max) {
                max = map.get(word);
                mostCommonWord = word;
            }
        }
      return mostCommonWord;
    }
}
