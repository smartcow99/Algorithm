import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        for (int[] vertex : edge) {
            graph.get(vertex[0]).add(vertex[1]);
            graph.get(vertex[1]).add(vertex[0]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        
        que.offer(1);
        dist[1] = 0;
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            for (int nxt : graph.get(cur)) {
                if(dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    que.offer(nxt);
                }
            }
        }
        int maxi = 0;
        for (int d : dist) {
            maxi = Math.max(maxi, d);
        }
        
        int count = 0;
        for (int d : dist) {
            if (d == maxi) count++;
        }
        
        return count;
    }
}