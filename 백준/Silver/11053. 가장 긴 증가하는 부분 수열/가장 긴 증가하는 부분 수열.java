import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] arr;
  static int[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    dp = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    dp[0] = 1;
    for (int i = 0; i < N; i++){
      dp[i] = 1;
      for (int j = 0; j < i; j++){
        if (arr[i] > arr[j]){
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < N; i++){
      result = Math.max(result, dp[i]);
    }
    System.out.println(result);
  }
}
