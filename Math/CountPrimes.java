/**
* Algorithm: Sieve of Eratosthenes
* Note: prime numbers start from 2
*/
class Solution {
    public int countPrimes(int n) {
        // 1. assume all the numbers between 0 to n are prime
        boolean[] primes = new boolean[n];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        
        // 2. making false all the multiples of numbers starting from 2, first prime number
        // NOTE: there are no primes greater than N/2
        for (int i = 2; i * i < n; i++) {
            // set all the multples of i to false
            if (primes[i] == true) {
                for (int j = i; j * i < n; j++) {
                    primes[i * j] = false;
                }
            }
        }
        
        // 3. count the number of true primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == true) {
                count++;
            }
        }
        
        return count;
    }
}