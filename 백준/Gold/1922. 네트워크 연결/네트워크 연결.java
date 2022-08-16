import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, a, b, c;

    static class Edge implements Comparable<Edge> {
        public int to;
        public int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int[][] adj = new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adj[a][b] = c;
            adj[b][a] = c;
        }
        int result = prim(n, adj);
        System.out.println(result);
    }

    static int prim(int n, int[][] adj) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int currentEdge = 1;

        int totalWeight = 0;

        while(true) {
            visited[currentEdge] = true;
            for(int i=1; i<n+1; i++) {
                if(adj[currentEdge][i] != 0 && !visited[i]) {
                    pq.add(new Edge(i, adj[currentEdge][i]));
                }
            }
            currentEdge = -1;

            while(!pq.isEmpty()) {
                Edge edge = pq.poll();

                if(!visited[edge.to]) {
                    totalWeight += edge.weight;
                    currentEdge = edge.to;
                    break;
                }
            }
            if(currentEdge == -1)
                break;
        }
        return totalWeight;
    }
}

