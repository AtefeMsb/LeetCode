class WordDistance {
    
    Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        
        // the array list of indices would be automatically sorted,
        // because we scan from the begining of the array to the end
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int res = Integer.MAX_VALUE;
        int l1 = 0;
        int l2 = 0;
        
        while (l1 < list1.size() && l2 < list2.size()) {
            res = Math.min(res, Math.abs(list1.get(l1) - list2.get(l2)));
            
            // the list pointer that has lower indices would move forward
            // the goal is to find closet indices
            if (list1.get(l1) < list2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */