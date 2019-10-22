/*
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int[] results = new int[2];
        // calculate sum of each arr
        int sumA = 0;
        for (int a: A) {
            sumA += a;
        }
        
         int sumB = 0;
        for (int b: B) {
            sumB += b;
        }
        
        
        for (int a : A) {
            for (int b : B) {
                if (sumA - a + b == sumB - b + a) {
                    results[0] = a;
                    results[1] = b;
                    break;
                }
            }
        }
        
        return results;
        
    }
}
*/

/* solution from leetcode
if alice gives a
    bob gives b
    sumA - a + b = sumB - b + a
    b = a + (sumB - sumA)/2
    
    so if alice gives away a, bob has to have candy a + (sumB - sumA)/2
    put B in a set
*/

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        int[] results = null;
        
        // calculate sum of each arr
        int sumA = 0;
        for (int a: A) {
            sumA += a;
        }
        
         int sumB = 0;
        for (int b: B) {
            sumB += b;
        }
        
        int diff = (sumB - sumA) / 2;
        
        Set<Integer> setB = new HashSet();
        for (int b : B) {
            setB.add(b);
        }
        
        for (int a : A) {
            if (setB.contains(a + diff)) {
                results = new int[] {a, a + diff};
            }
        }
        
        return results;
        
    }
}
