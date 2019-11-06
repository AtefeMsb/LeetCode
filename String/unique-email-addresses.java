class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();
        int count = 0;
        
        for (String email : emails) {
            
            String[] details = email.split("@");
            String local = details[0];
            // keep domain as it is
            String domain = details[1];
            
            // save whatever before +
            local = local.split("\\+")[0];
            // remove all the "."
            local = local.replace(".", "");
            
            String finalEmail = local + "@" + domain;
            // add to set
            if (set.add(finalEmail)) {
                count++;
            }    
         }    
        return count;  
    }
}
