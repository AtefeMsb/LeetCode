package AuguestChallenge2020;

// GREEDY
class LongestPalindrome {
    public int longestPalindrome(String s) {
        
        int longest = 0;
        boolean oddWasAdded = false;
        int[] charCount = new int[128];
    
        // counting occurance of each character 
        for (char ch : s.toCharArray()) {
            charCount[ch]++;
        }
        
        System.out.println(Arrays.toString(charCount));
        
        for (int cnt : charCount) {
            
            // if the cnt is odd and the middle value hasnt been add to the count yet.
            if (cnt % 2 == 1 && oddWasAdded == false) {
                oddWasAdded = true;
                longest += 1;
            }
            
            // add the even part of all the couynts
            longest += cnt - (cnt % 2);
        }
    
        return longest;
    }
}