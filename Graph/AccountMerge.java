/**
 * solution 1: using adjacency list and graph
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> mergedAccounts = new LinkedList<>();
        
        Map<String, String> emailNameMap = new HashMap<>();
        Map<String, Set<String>> emailGraph = new HashMap<>();
        
        // 1. generate a graph (adjacency list)
        for (List<String> account : accounts) {
            String name = account.get(0);
            // there is no emails associated with this name
            if (account.size() == 1) {
                List<String> tempAccount = new LinkedList<>();
                tempAccount.add(name);
                mergedAccounts.add(tempAccount);
                continue;
            }
            
            // put the first email in and add other connected graph to it
            String firstEmail = account.get(1);
            emailNameMap.put(firstEmail, name);
            if (!emailGraph.containsKey(firstEmail)) {
                emailGraph.put(firstEmail, new HashSet<>());   
            }
            
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                emailNameMap.put(email, name);
                if (!emailGraph.containsKey(email)) {
                    emailGraph.put(email, new HashSet<>());
                }
                
                // add edge both ways for adjacency graph 
                emailGraph.get(email).add(firstEmail);
                emailGraph.get(firstEmail).add(email);
            }
        }
        
        
        // 2. find connected components using DFS
        Set<String> visited = new HashSet<>();
        
        for (String email : emailGraph.keySet()) {
            // each account email list
            List<String> list = new ArrayList<>();
    
            if (visited.contains(email)) {
               continue; 
            }
            
            dfs(email, list, emailGraph, visited);
            Collections.sort(list);
            String name = emailNameMap.get(email);
            list.add(0, name);
            mergedAccounts.add(list);
        }   
        
        return mergedAccounts;
    }
    
    // this function finds conected components using dfs
    private void dfs(String email, List<String> list, Map<String, Set<String>> emailGraph, Set<String> visited) {
        
        if (visited.contains(email)) {
            return;
        }
        
        list.add(email);
        visited.add(email);
        
        for (String neighbor : emailGraph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, list, emailGraph, visited);
            }
        }
    }
    
}

/**
 * Solution 2: Union Find
 *
 * Use two hash map with union find class to solve the problem
 * @params mailToIndex: one to one mapping: mail string to its parent index mapping
 * @params disjointSet: one to many mapping: parent index to all emails that belong to same group mapping
 * */

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size() == 0) {
            return new ArrayList<>();
        }

        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        // Step 1: traverse all emails except names, if we have not seen an email before, put it with its index into map.
        // Otherwise, union the email to its parent index.
        Map<String, Integer> mailToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String curMail = accounts.get(i).get(j);
                if (mailToIndex.containsKey(curMail)) {
                    int preIndex = mailToIndex.get(curMail);
                    uf.union(preIndex, i);
                }
                else {
                    mailToIndex.put(curMail, i);
                }
            }
        }

        // Step 2: traverse every email list, find the parent of current list index and put all emails into the set list
        // that belongs to key of its parent index
        Map<Integer, Set<String>> disjointSet = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // find parent index of current list index in parent array
            int parentIndex = uf.find(i);
            disjointSet.putIfAbsent(parentIndex, new HashSet<>());

            Set<String> curSet = disjointSet.get(parentIndex);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                curSet.add(accounts.get(i).get(j));
            }
            disjointSet.put(parentIndex, curSet);
        }

        // step 3: traverse ket set of disjoint set group, retrieve all emails from each parent index, and then SORT
        // them, as well as adding the name at index 0 of every sublist
        List<List<String>> result = new ArrayList<>();
        for (int index : disjointSet.keySet()) {
            List<String> curList = new ArrayList<>();
            if (disjointSet.containsKey(index)) {
                curList.addAll(disjointSet.get(index));
            }
            Collections.sort(curList);
            curList.add(0, accounts.get(index).get(0));
            result.add(curList);
        }
        return result;
    }

    class UnionFind {
        int size;
        int[] parent;
        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            parent[find(a)] = parent[find(b)];
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

}