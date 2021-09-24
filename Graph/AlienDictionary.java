class Solution {
    public String alienOrder(String[] words) {
        
        // 1. create an adjacency list
        Map<Character, List<Character>> graph = new HashMap<>();
        List<Character> chars = new ArrayList<>();
        
        // create list for each character in the map
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!graph.containsKey(ch)) {
                    chars.add(ch);
                    graph.put(ch, new ArrayList<Character>());
                }
            }
        }
        
        // compare each 2 adjacent word together
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            
            // edge case, if "abcd" comes before "abc". there will be no answer.
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            
            // normal case, look for the first dissimilarities in two words
            for (int j = 0; j < minLen; j++) {
                // first diffrence found and add to the graph and break
                if (w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        
        // 2. look for cycle in the graph
        if (isCyclic(graph, chars)) {
            System.out.println("this graph has cycle so it is impossible to find its topological order");
            return "";
        }
  
        // 3. if there is no cycle presents, use dfs to find the topological ordering 
        Set<Character> visited = new HashSet<>();
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder toplogicalOrder = new StringBuilder();
        
        for (char ch : chars) {
            if (!visited.contains(ch)) {
                dfs(graph, visited, stack, ch);
            }
        }
        
        // stack has the topological ordering in reverse, so when pop will be the right order
        while (!stack.isEmpty()) {
            toplogicalOrder.append(stack.pop());
        }
  
        return toplogicalOrder.toString();
    }
    
    // TOPOLOGICAL SORT ALGORITHM - using DFS and Stack
    private void dfs(Map<Character, List<Character>> graph, Set<Character> visited, LinkedList<Character> stack, char c) {
        
        visited.add(c);
        for (char dest : graph.get(c)) {
            if (!visited.contains(dest)) {
                dfs(graph, visited, stack, dest);
            }
        }
        stack.push(c);
    }
    
    // FINDING OUT IF GRAPH HAS CYCLE
    private boolean isCyclic(Map<Character, List<Character>> graph, List<Character> chars) {
        // state of each course vertices
        // 0 means UNVISITED
        // 1 means VISITING
        // 2 means VISITED
        // int[] states = new int[chars.size()];
        Map<Character, Integer> states = new HashMap<>();
        for (char cur : chars) {
            states.put(cur, 0);
        }
        
        for (char ch : chars) {
            if (states.get(ch) == 0) {
                if (isCyclicUtil(graph, states, ch)) return true;
            }
        } 
        return false;  
    }

    private boolean isCyclicUtil(Map<Character, List<Character>> graph, Map<Character, Integer> states, char ch) {

        // processing a node in "visiting" state means there is a cycle
        if (states.get(ch) == 1) return true;
        // make the node state "visiting"
        states.put(ch, 1);

        // run dfs recursively for each of its destination
        for (char dest : graph.get(ch)) {
            if (states.get(dest) != 2) {
                if (isCyclicUtil(graph, states, dest)) return true;
            }
        }

        // make the node state "visited"
        states.put(ch, 2);
        return false;
    }
}