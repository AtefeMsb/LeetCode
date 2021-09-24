class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < b.length()) {
            sb = sb.append(a);
            count++;
        }
        
        if (sb.toString().contains(b)) {
            return count;
        }
        
        if (sb.append(a).toString().contains(b)) {
            count++;
            return count;
        }
        
        return -1;      
    }
}