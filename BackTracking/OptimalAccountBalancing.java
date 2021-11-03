// transactions[i] = [from, to, amount]
class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);    // lost
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);    // gain
        }
        
        return settle(0, new ArrayList<>(m.values()));
    }

    int settle(int start, List<Integer> debt) {
        
        // skip the accounts with no debt
        while (start < debt.size() && debt.get(start) == 0) {
            start++;
        }
        
        // base case
        if (start == debt.size()) return 0;
        
        int result = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++) {
            
            if (debt.get(start) * debt.get(i) < 0) {    // opposite sign
                debt.set(i, debt.get(i) + debt.get(start));     // choose
                result = Math.min(result, 1 + settle(start + 1, debt));   // backtrack
                debt.set(i, debt.get(i) - debt.get(start));     // unchoose
            }
        }
        return result;
        
    }
}