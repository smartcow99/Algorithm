import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int N;
  static int X;
  static int Y;
  static List<List<Integer>> arr;
  static int[] parent;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    arr = new ArrayList<>();
    visited = new boolean[N+1];
    parent = new int[N+1];
    for (int i = 0; i <= N; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < N-1; i++) {
      st = new StringTokenizer(br.readLine());
      X = Integer.parseInt(st.nextToken());
      Y = Integer.parseInt(st.nextToken());
      arr.get(Y).add(X);
      arr.get(X).add(Y);
    }
    bfs();

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= N; i++) {
      sb.append(parent[i]).append("\n");
    }
    System.out.println(sb);
  }
  static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    visited[1] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for(int nxt:arr.get(cur)){
        if(!visited[nxt]){
          visited[nxt] = true;
          parent[nxt] = cur;
          queue.add(nxt);
        }
      }
    }

  }
}
