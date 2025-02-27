import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[][] arr;
  static int[][] dp;
  static int result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    dp = new int[n][n];
    arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, dfs(i, j));

      }
    }
    System.out.println(result);
  }
  static public int dfs(int i, int j) {
    if (dp[i][j] != 0) {
      return dp[i][j];
    }
    dp[i][j] = 1;

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    for (int k = 0; k < 4; k++) {
      int nx = i + dx[k];
      int ny = j + dy[k];

      if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

      if (arr[nx][ny] > arr[i][j]) {
        dp[i][j] = Math.max(dp[i][j], dfs(nx, ny) + 1);
      }
    }
    return dp[i][j];
  }
}