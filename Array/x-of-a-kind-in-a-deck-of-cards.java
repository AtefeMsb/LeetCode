class Solution {
     public boolean hasGroupsSizeX (int[] deck) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int result = 0;
        // key: int, value: frequency/count
        for (int i : deck) {
            if (frequencyMap.containsKey(i)) {
                frequencyMap.put(i, frequencyMap.get(i) + 1);
            } else {
                frequencyMap.put(i, 1);
            }
        }
         
        for (int i : frequencyMap.values()) {
            result = gcd(i, result);  
        }
         
        return result > 1;
    }

    public int gcd (int a, int b) {
        // base cases
        if (a == 0) return b;
        if (b == 0) return a;
        
        // decrease and conqure
        return gcd(b, a%b);
    }
}
