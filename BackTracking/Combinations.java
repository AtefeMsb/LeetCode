package BackTracking;

class Combinations {
    int n;
    int k;
    List<List<Integer>> combinations =  new LinkedList();
    
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        
        createCombination(1, new LinkedList<Integer>());
        
        System.out.println(combinations);
        
        return combinations;
    }
    
    // backtracking algorithm
    private void createCombination(int start, LinkedList<Integer> current) {
        
        if (current.size() == k) {
            combinations.add(new LinkedList(current));
            return;
        }
        
        for (int i = start; i <= n ; i++) {
            current.add(i);
            createCombination(i + 1, current);
            current.removeLast();
        }
        
    }
}