import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  private static class Node implements Comparable<Node> {
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }

  static int V, E;
  static int[] parent;
  static ArrayList<Node> nodeList;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    nodeList = new ArrayList<>();
    parent = new int[V + 1];

    for (int i = 0; i <= V; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      nodeList.add(new Node(from, to, cost));
    }
    Collections.sort(nodeList);
    int sum = 0;
    int count = 0;
    int max = 0;
    for (Node node : nodeList) {
      if (union(node.from, node.to)) {
        sum += node.cost;
        count++;
        max = node.cost;
        if (count == V - 1) break;
      }
    }
    System.out.println(sum - max);

  }

  public static boolean union(int from, int to) {
    int fromRoot = find(from);
    int toRoot = find(to);

    if (fromRoot == toRoot) return false;
    parent[toRoot] = fromRoot;
    return true;
  }

  public static int find(int v) {
    if (parent[v] == v) return v;
    return parent[v] = find(parent[v]);
  }
}