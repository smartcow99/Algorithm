import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    List<Integer> list = new ArrayList<>();
    boolean[] visited = new boolean[N + 1];
    List<List<Integer>> answer = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= N; i++) {
      list.add(i);
    }

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

    for (int i = start; i <= arr.size(); i++) {
      visited[i] = true;
      temp.add(arr.get(i - 1));
      comb(answer, arr, visited, i + 1, r - 1, temp);
      temp.remove(temp.size() - 1);
      visited[i] = false;
    }
  }
}
