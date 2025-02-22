import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[][] matrix;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    matrix = new int[n][3];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] max_dp = matrix[0].clone();
    int[] min_dp = matrix[0].clone();

    for (int i = 1; i < n; i++) {
      int prev_max0 = max_dp[0], prev_max1 = max_dp[1], prev_max2 = max_dp[2];
      int prev_min0 = min_dp[0], prev_min1 = min_dp[1], prev_min2 = min_dp[2];

      max_dp[0] = matrix[i][0] + Math.max(prev_max0, prev_max1);
      max_dp[1] = matrix[i][1] + Math.max(Math.max(prev_max0, prev_max1), prev_max2);
      max_dp[2] = matrix[i][2] + Math.max(prev_max1, prev_max2);

      min_dp[0] = matrix[i][0] + Math.min(prev_min0, prev_min1);
      min_dp[1] = matrix[i][1] + Math.min(Math.min(prev_min0, prev_min1), prev_min2);
      min_dp[2] = matrix[i][2] + Math.min(prev_min1, prev_min2);
    }

    int max_result = Math.max(Math.max(max_dp[0], max_dp[1]), max_dp[2]);
    int min_result = Math.min(Math.min(min_dp[0], min_dp[1]), min_dp[2]);

    System.out.println(max_result + " " + min_result);
  }
}
