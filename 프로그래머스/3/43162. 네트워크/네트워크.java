import java.util.HashSet;

class Solution {
    static int[] parents;
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for (int i=0; i<n; i++) {
            parents[i] = i;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        HashSet<Integer> cnt = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cnt.add(find(i));
        }
        
        return cnt.size();
    }
    
    public static int find(int network) {
        if (parents[network] == network) return network;
        parents[network] = find(parents[network]);
        return parents[network];
    }
    
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if (p1 > p2) {
            parents[p1] = p2;
        } else if(p1 < p2) {
            parents[p2] = p1;
        }
    }
}