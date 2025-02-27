import java.util.*;

class Solution {
    private int[] rank;
    private int[] parent;
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = {};
        int maxi = Arrays.stream(nodes).max().orElse(0);
        
        rank = new int[maxi + 1];
        parent = new int[maxi + 1];
        for(int i = 1; i <= maxi; i++) {
            parent[i] = i;
        }
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            rank[a]++;
            rank[b]++;
            union(a, b);
        }
        
        Map<Integer, TreeInfo> MAP = new HashMap();
        for(int node : nodes) {
            int group = find(node);
            
            TreeInfo t = MAP.getOrDefault(group, new TreeInfo());
            
            if((node % 2 == 0) && (rank[node] % 2 == 0)) {
                t.evenNode++;
            } else if((node % 2 == 1) && (rank[node] % 2 == 1)) {
                t.oddNode++;
            } else if((node % 2 == 0) && (rank[node] % 2 == 1)) {
                t.reverseEvenNode++;
            } else if((node % 2 == 1) && (rank[node] % 2 == 0)) {
                t.reverseOddNode++;
            }
            
            MAP.put(group, t);
        }
        
        int tree = 0;
        int rTree = 0;
        for(TreeInfo treeInfo : MAP.values()) {
            if(treeInfo.isTree()) {
                tree++;
            }
            
            if(treeInfo.isReverseTree()) {
                rTree++;
            }    
        }
        
        return new int[]{tree, rTree};
    }
               
    public class TreeInfo {
        public int oddNode;
        public int evenNode;
        public int reverseOddNode;
        public int reverseEvenNode;
        
        public TreeInfo() {
            this.oddNode = 0;
            this.evenNode = 0;
            this.reverseOddNode = 0;
            this.reverseEvenNode = 0;
        }
        
        public boolean isTree() {
            if((oddNode == 1 && evenNode == 0) || (oddNode == 0 && evenNode == 1)) {
                return true;
            }
            
            return false;
        }
        
        public boolean isReverseTree() {
            if((reverseOddNode == 1 && reverseEvenNode == 0) || (reverseOddNode == 0 && reverseEvenNode == 1)) {
                return true;
            }
            
            return false;
        }
    }
    
    public int find(int num) {
        if(parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) {
            parent[b] = a;
        }
    }
}