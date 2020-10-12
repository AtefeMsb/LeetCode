package String;

class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        
        if (A.length() == 0 || B.length() == 0) return false;
        if (A.length() != B.length()) return false;

        // case 1: if A == B, there must be one duplicate character at least
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char ch : A.toCharArray()) {
                set.add(ch);
            }
            
            // if there is at least one duplicate character
            return set.size() < A.length();
        }
        
        // case 2: A and B only have only two diffrent characters
        List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diffs.add(i);
            }
        }
        
        return diffs.size() == 2 &&
            A.charAt(diffs.get(0)) == B.charAt(diffs.get(1)) &&
            A.charAt(diffs.get(1)) == B.charAt(diffs.get(0));
    }
}