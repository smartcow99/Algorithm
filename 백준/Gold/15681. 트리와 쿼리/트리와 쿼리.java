import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int n, root, query;
  static ArrayList<Integer>[] adj;
  static int[] subtree;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    root = Integer.parseInt(st.nextToken());
    query = Integer.parseInt(st.nextToken());

    adj = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj[a].add(b);
      adj[b].add(a);
    }

    subtree = new int[n + 1];
    visited = new boolean[n + 1];

    dfs(root);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < query; i++) {
      int q = Integer.parseInt(br.readLine());
      sb.append(subtree[q]).append("\n");
    }
    System.out.print(sb);
  }

  static int dfs(int node) {
    visited[node] = true;
    subtree[node] = 1;

    for (int next : adj[node]) {
      if (!visited[next]) {
        subtree[node] += dfs(next);
      }
    }
    return subtree[node];
  }
}
