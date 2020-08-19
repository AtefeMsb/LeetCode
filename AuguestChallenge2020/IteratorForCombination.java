package AuguestChallenge2020;

class IteratorForCombination {
    
    private String s;
    Queue<String> queue;
    
    // Generate all combinations as a preprocessing - usinmgh backtracking
    private void createCombination(int start, int length, StringBuilder txt) {
        
        // if the current combination is the length we are looking for
        if (length == 0) {
            queue.offer(txt.toString());
            return;
        }
        
        for (int i = start; i <= s.length() - length; i++) {
            
            // // add i into the current combination
            txt.append(s.charAt(i));
            
            // use next integers to complete the combination
            createCombination(i + 1, length - 1, txt);
            
            // backtrack
            txt.deleteCharAt(txt.length() - 1);
        }
        
    }

    public CombinationIterator(String characters, int combinationLength) {
        
        s = characters;
        queue = new ArrayDeque<String>();
        createCombination(0, combinationLength, new StringBuilder());
    }
    
    public String next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return (!queue.isEmpty());
    }
}