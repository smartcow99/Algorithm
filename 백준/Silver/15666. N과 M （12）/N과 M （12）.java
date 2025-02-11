import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, M;
  static int[] result;
  static StringBuilder sb = new StringBuilder();
  static List<Integer> arr;
  static Set<Integer> set;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    set = new HashSet<>();
    result = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }

    arr = new ArrayList<>(set);
    Collections.sort(arr);

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

    for (int i = 0; i < arr.size(); i++) {
      if (depth > 0 && result[depth - 1] > arr.get(i)) continue;

      result[depth] = arr.get(i);
      dfs(depth + 1);
    }
  }
}
