package Heap;

class Solution {
    public String reorganizeString(String S) {
        
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : S.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        // max heap with respect to the character frequencies
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1,c2) -> counts.get(c2) - counts.get(c1));                                   
        maxHeap.addAll(counts.keySet());
        
        StringBuilder result = new StringBuilder();
        // pick the two most frequent character and add them to result
        while (maxHeap.size() > 1) {
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            result.append(current);
            result.append(next);
            // update the frequency map
            counts.put(current, counts.get(current) - 1);
            counts.put(next, counts.get(next) - 1);
            // if the count of the character not zero, put them back in the maxHeap
            if (counts.get(current) > 0) {
                maxHeap.add(current);
            }
            if (counts.get(next) > 0) {
                maxHeap.add(next);
            }   
        }
        
        // if there is only one character left in the heap
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            // if it has more than one occurence, there is no way to put them not adjacent to each other 
            if (counts.get(last) > 1) {
                return "";
            }
            result.append(last);
        }
        
        return result.toString();
    }
}