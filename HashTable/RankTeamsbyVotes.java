class Solution {
    public String rankTeams(String[] votes) {
    
        Map<Character, int[]> map = new HashMap<>();
        int n = votes[0].length();
        for(String vote : votes){
            for(int i = 0; i < n; i++){
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[n]);
                map.get(c)[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list, (a,b) -> {
            for(int i = 0; i < n; i++){
                if(map.get(a)[i] != map.get(b)[i]) {      // If team1 and team2 don't tie on the `ith` position
                    return map.get(b)[i] - map.get(a)[i]; // return team with higher votes
                }
            }
            return a - b; // return team with lower alphabetically letter
        });

        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        
        return sb.toString();
    }
}