class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> stack = new LinkedList<>();
        
        visited.add(0);
        stack.push(0);
        
        while (!stack.isEmpty()) {
            
            int cur = stack.pop();
            List<Integer> keys = rooms.get(cur);
            
            for (int key : keys) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    stack.push(key);
                }
            }
       
        }
        
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited.contains(i)) {
                return false;
            }
        }
        
        return true;
    }
}