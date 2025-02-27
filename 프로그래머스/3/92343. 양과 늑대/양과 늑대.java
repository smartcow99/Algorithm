import java.util.ArrayList;
import java.util.List;

class Solution {
    static int maxSheep = 0;
    static ArrayList<ArrayList<Integer>> graph;
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        dfs(0, 1, 0, nextNodes, info);

        return maxSheep;
    }
    
    public static void dfs(int node, int sheep, int wolf, List<Integer> nextNodes, int[] info) {
        maxSheep = Math.max(maxSheep, sheep);

        List<Integer> newNextNodes = new ArrayList<>(nextNodes);
        newNextNodes.remove(Integer.valueOf(node));
        newNextNodes.addAll(graph.get(node));

        for (int next : newNextNodes) {
            if (info[next] == 0) {
                dfs(next, sheep + 1, wolf, newNextNodes, info);
            } else if (sheep > wolf + 1) {
                dfs(next, sheep, wolf + 1, newNextNodes, info);
            }
        }
    }
}

