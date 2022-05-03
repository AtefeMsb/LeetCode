class Solution {
    public String countAndSay(int n) {
        
        if (n <= 0) return "";
        
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = util(res);
        }
        
        return res;
    }
    
    private String util(String str) {
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while (i < str.length()) {
            int j = i;
            
            while (j < str.length() && str.charAt(j) == str.charAt(i)) {
                j++;
            }
            
            String count = j - i + "";
            char ch = str.charAt(i);
            
            sb.append(count);
            sb.append(ch);
            
            i = j;
        }
    
        return sb.toString();
    }
}