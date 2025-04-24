import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    public int solution(int n, int[][] wires) {
        int mini = Integer.MAX_VALUE;
        
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires) {
            graph.get(wire[0]).remove((Integer) wire[1]);
            graph.get(wire[1]).remove((Integer) wire[0]);
            int diff = Math.abs(checkNum(wire[0], n) - checkNum(wire[1], n));
            mini = Math.min(mini, diff);
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        return mini;
    }
    
    public int checkNum(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int count = 1;
        
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    count++;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}