import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, M;
  static int[] arr;
  static boolean[] visited;
  static int[] result;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    visited = new boolean[N];
    result = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    dfs(0);
    System.out.print(sb);
  }

  static void dfs(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(result[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i]) continue;
      if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;

      visited[i] = true;
      result[depth] = arr[i];
      dfs(depth + 1);
      visited[i] = false;
    }
  }
}
