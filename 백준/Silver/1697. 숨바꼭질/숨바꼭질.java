import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  static final int MAX = 100000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] time = new int[MAX + 1];
    Arrays.fill(time, Integer.MAX_VALUE);

    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(n);
    time[n] = 0;

    while (!deque.isEmpty()) {
      int cur = deque.poll();

      if (cur == k) {
        System.out.println(time[cur]);
        return;
      }

      if (cur * 2 <= MAX && time[cur * 2] > time[cur]) {
        time[cur * 2] = time[cur] + 1;
        deque.addFirst(cur * 2);
      }

      if (cur - 1 >= 0 && time[cur - 1] > time[cur] + 1) {
        time[cur - 1] = time[cur] + 1;
        deque.addLast(cur - 1);
      }

      if (cur + 1 <= MAX && time[cur + 1] > time[cur] + 1) {
        time[cur + 1] = time[cur] + 1;
        deque.addLast(cur + 1);
      }
    }
  }
}
