public class Solution {
    public String countAndSay(int n) {
        
        if (n <= 0) {
            return "";
        }
        
        String result = "1";
        
        for (int i = 1; i < n; i ++) {
            result = build(result);
        }
        
        return result;
    }
    
    private String build(String result) {
        
        StringBuilder builder = new StringBuilder();
        // pointer p
        int p = 0;
        while(p < result.length()) {
            char val = result.charAt(p);
            int count = 0;
            
            // while pointer is less than the end of array and still seeing the same val
            // increase the count of occurence of the val
            while (p < result.length() && result.charAt(p) == val){
                p++;
                count++;
            }
            
            // add the count to the result
            builder.append(String.valueOf(count));
            // add the val right after
            builder.append(val);
        }
        
        return builder.toString();
    }
}