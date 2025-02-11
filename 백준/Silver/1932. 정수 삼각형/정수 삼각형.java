import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int result;
  static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < i + 1; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {
          arr[i][j] += arr[i - 1][j];
        } else if (j == i) {
          arr[i][j] += arr[i - 1][j - 1];
        } else {
          arr[i][j] += Math.max(arr[i - 1][j], arr[i- 1][j - 1]);
        }
      }
    }
    for(int i=0; i<n; i++) {
      result = Math.max(result, arr[n-1][i]);
    }
    System.out.println(result);
  }
}
