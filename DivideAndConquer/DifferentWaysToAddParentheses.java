class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '*' || c == '+') {
                String a = expression.substring(0, i);
                String b = expression.substring(i + 1);
                
                List<Integer> aResult = diffWaysToCompute(a);
                List<Integer> bResult = diffWaysToCompute(b);
                
                for (int aa : aResult) {
                    for (int bb : bResult) {
                        if (c == '*') {
                            result.add(aa * bb);
                        } else if (c == '+') {
                            result.add(aa + bb);
                        } else if (c == '-') {
                            result.add(aa - bb);
                        }
                    }
                }
                
            }
      
        }
        
        // if we have only a digit
        if (result.size() == 0) result.add(Integer.valueOf(expression));
        
        return result;
        
    }
}