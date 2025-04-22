import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int s = road[0];
            int e = road[1];
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        dist[destination] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int neighbor : graph.get(cur)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[cur] + 1;
                    q.offer(neighbor);
                }
            }
        }
        int[] answer = new int[sources.length];
        for (int i=0; i<sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}