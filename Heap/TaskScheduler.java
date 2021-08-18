package Heap;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // count the frequency of each task
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // put all the frequencie in maxHeap, because we want to start from the highest frequency task
        // and spread it through the cycles, to have a more effiecient use of cpu time
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());
                
        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            
            List<Integer> temp = new ArrayList<>();
            
            // for the length of cooldown (n) we need new characters to run interchangeably
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    // this is simulating running the task, by adding it to the list
                    temp.add(maxHeap.remove());
                }
            }
            
            // if any of the task still not finished, add back to the heap
            for (int i : temp) {
                if (--i > 0) {
                    maxHeap.add(i);
                }
            }
            
            // if heap is empty, only need to increment by the num of tasks we ran
            // but in any other case it takes cooldown cycle amount to run
            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
            
        }
        
        return cycles;   
    }
}
