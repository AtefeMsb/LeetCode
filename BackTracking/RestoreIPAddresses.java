class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // if there is more than 3 * 4 characters, it is impossible to be IP address
        if (s.length() > 12) {
            return result;
        }
        dfs(result, s, 0, 0, new StringBuilder());
        return result;  
    }
    
    // i: index, dots: number of dots planned so far, cur: current ip address so far
    public void dfs(List<String> result, String s, int i, int dots, StringBuilder cur) {
        
        // base cases
        // if we placed 4 dots and reach the end of string s
        if (dots == 4 && i == s.length()) {
            // remove the last dot (the 4th dot is unecessory for ip address)
            cur.deleteCharAt(cur.length() - 1);
            result.add(new String(cur));
            return;
        }
        
        if (dots > 4) {
            return;
        }
        
        // segments of 1 to 3 length
        for (int j = i; j < Math.min(i + 3, s.length()); j++) {
            // choose
            String seg = s.substring(i, j + 1);
            int intSeg = Integer.parseInt(seg);
                        
            // if a valid segment
            // integer less than 256 and no leading zeroes
            if (intSeg < 256 && (i == j || seg.charAt(0) != '0')) {
                // choose
                cur.append(seg);
                cur.append(".");
                dots++;
                
                // recurse
                dfs(result, s, j + 1, dots, cur);
                
                // unchoose
                cur.deleteCharAt(cur.length() - 1);
                while (cur.length() > 0 && cur.charAt(cur.length() - 1) != '.') {
                    cur.deleteCharAt(cur.length() - 1);
                }
                dots--;
            }    
        }
            
    }
}