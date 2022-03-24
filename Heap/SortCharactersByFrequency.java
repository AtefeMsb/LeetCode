class Solution {
    public String frequencySort(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        // count the frequency
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // get in order
        // max heap
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char ch : map.keySet()) {
            heap.add(ch);
        }
        
        while (!heap.isEmpty()) {
            char cur = heap.remove();
            int repeat = map.get(cur);
            for (int i = 0; i < repeat; i++) {
                sb.append(cur);
            }
        }
        
        
        return sb.toString();   
    }
}