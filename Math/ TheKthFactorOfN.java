// brute force
class Solution {
    public int kthFactor(int n, int k) {
        
        List<Integer> factors = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            
            if (n % i == 0) {
                factors.add(i);
            }
  
        }
        
        if (factors.size() < k) return -1;
        
        return factors.get(k - 1); 
    }
}
// ------------------------------------------------