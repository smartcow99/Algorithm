import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> answer = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] visited = new boolean[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(list);

    comb(answer, list, visited, 1, M, new ArrayList<>());

    for (List<Integer> integers : answer) {
      for (Integer integer : integers) {
        sb.append(integer).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static void comb(List<List<Integer>> answer, List<Integer> arr, boolean[] visited, int start, int r, List<Integer> temp) {
    if (r == 0) {
      answer.add(new ArrayList<>(temp));
      return;
    }

    for (int i = 1; i <= arr.size(); i++) {
      if (!visited[i]) {
        visited[i] = true;
        temp.add(arr.get(i - 1));
        comb(answer, arr, visited, i + 1, r - 1, temp);
        temp.remove(temp.size() - 1);
        visited[i] = false;
      }
    }
  }
}
