class Solution {
    public String simplifyPath(String path) {
        
        String[] parts = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        
        for (String str : parts) {
            
            if (str.isEmpty() || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } 
            } else {
                stack.push(str);
            }    
        }
        
        StringBuilder res = new StringBuilder();
        
        // reverse the order of  stack content
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        
        for (String dir : list) {
            res.append("/");
            res.append(dir);
        }
        
        return res.length() > 0 ? res.toString() : "/";
    }
}