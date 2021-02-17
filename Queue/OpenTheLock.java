package Queue;

// bfs
class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        
        Deque<String> queue = new ArrayDeque<>();
        queue.add("0000");
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                
                if (deadEnds.contains(str)) {
                    continue;
                }
                
                if (str.equals(target)) {
                    return level;
                }
                
                StringBuilder sb = new StringBuilder(str);
                // for each character, one time add a step, one time remove a step
                // ch - '0' : converts the char to int
                for (int j = 0; j < 4; j++) {
                    char ch = sb.charAt(j);
                    // add one step
                    String s1 = sb.substring(0, j) + (ch == '9' ? 0 : ch - '0' + 1) + sb.substring(j+1);
                    // subtract one step
                    String s2 = sb.substring(0, j) + (ch == '0' ? 9 : ch - '0' - 1) + sb.substring(j+1);
                    
                    if (!visited.contains(s1) && !deadEnds.contains(s1)) {
                        visited.add(s1);
                        queue.offer(s1);
                    }
                    
                    if (!visited.contains(s2) && !deadEnds.contains(s2)) {
                        visited.add(s2);
                        queue.offer(s2);
                    }  
                }
                
            }
            
            level++;  
        }
        
        return -1;
        
    }
}