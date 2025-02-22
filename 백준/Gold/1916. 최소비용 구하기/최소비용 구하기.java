import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
  int index;
  int cost;

  public Node(int index, int cost) {
    this.index = index;
    this.cost = cost;
  }

  @Override
  public int compareTo(Node o) {
    return Integer.compare(this.cost, o.cost);
  }
}

public class Main {

  static int n;
  static int m;
  static int start;
  static int end;
  static int cost;
  static ArrayList<Node>[] graph;
  static boolean[] visited;
  static int[] dist;
  static PriorityQueue<Node> pq;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());

    visited = new boolean[n+1];
    dist = new int[n+1];
    int INF = Integer.MAX_VALUE;
    Arrays.fill(dist, INF);
    graph = new ArrayList[n+1];
    for(int i=0; i<n+1; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      cost = Integer.parseInt(st.nextToken());
      graph[start].add(new Node(end, cost));
    }
    pq = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());

    pq.add(new Node(start, 0));
    dist[start] = 0;

    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      if(visited[cur.index]) continue;
      visited[cur.index] = true;

      for(Node next : graph[cur.index]) {
        if(!visited[next.index]) {
          if(dist[next.index] > dist[cur.index] + next.cost) {
            dist[next.index] = dist[cur.index] + next.cost;

            pq.add(new Node(next.index, dist[next.index]));
          }
        }
      }
    }
    System.out.println(dist[end]);
  }
}
