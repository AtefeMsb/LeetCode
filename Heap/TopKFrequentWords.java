package Heap;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // answer should be sorted by frequency from highest to lowest.
        // If two words have the same frequency, then the word with the lower alphabetical order comes first.
        PriorityQueue<String> minHeap = new PriorityQueue<>
            ((w1, w2) -> map.get(w1) == map.get(w2) ? w2.compareTo(w1) : map.get(w1)-map.get(w2));
            
        for (String word : map.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        
        List<String> results = new ArrayList();
        while (!minHeap.isEmpty()) {
            results.add(minHeap.remove());
        }
        Collections.reverse(results);
        return results;

    }
}