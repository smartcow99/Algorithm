import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] liquids = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      liquids[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int right = n - 1;
    int mini = Integer.MAX_VALUE;
    int ansLeft = 0;
    int ansRight = 0;

    while (left < right) {
      int sum = liquids[left] + liquids[right];
      int absSum = Math.abs(sum);

      if (absSum < mini) {
        mini = absSum;
        ansLeft = liquids[left];
        ansRight = liquids[right];
      }

      if (sum == 0) {
        break;
      }

      if (sum < 0) {
        left++;
      } else {
        right--;
      }
    }

    System.out.println(ansLeft + " " + ansRight);
  }
}
