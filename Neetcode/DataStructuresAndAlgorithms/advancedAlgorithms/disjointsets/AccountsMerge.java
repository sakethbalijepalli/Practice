package Neetcode.DataStructuresAndAlgorithms.advancedAlgorithms.disjointsets;

import java.util.*;

public class AccountsMerge {

    void main() {
        List<List<String>> accounts = List.of(
                List.of("neet", "neet@gmail.com", "neet_dsa@gmail.com"),
                List.of("alice", "alice@gmail.com"),
                List.of("neet", "bob@gmail.com", "neet@gmail.com"),
                List.of("neet", "neetcode@gmail.com")
        );

        List<List<String>> merged = accountsMerge(accounts);

        System.out.println(merged);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if(emailToAccount.containsKey(email)){
                    uf.union(i,emailToAccount.get(email));
                }
                emailToAccount.put(email,i);
            }
        }
        Map<Integer, TreeSet<String>> rootToEmails = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            int root = uf.find(i);
            for(int j = 1;j < account.size();j++){
                rootToEmails.computeIfAbsent(root, k -> new TreeSet<>()).add(account.get(j));
            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();

        for(Map.Entry<Integer,TreeSet<String>> mp : rootToEmails.entrySet()){
            List<String> mergedIds = new ArrayList<>();
            mergedIds.add(accounts.get(mp.getKey()).getFirst());
            mergedIds.addAll(mp.getValue());
            mergedAccounts.add(mergedIds);
        }
        return mergedAccounts;
    }
}
