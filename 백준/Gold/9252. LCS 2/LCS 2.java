import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();

    String result = lcs(s1, s2);
    System.out.println(result.length());
    System.out.println(result);
  }

  public static String lcs(String s1, String s2) {
    int l1 = s1.length();
    int l2 = s2.length();

    dp = new int[l1 + 1][l2 + 1];

    for (int i = 1; i <= l1; i++) {
      for (int j = 1; j <= l2; j++) {
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int n = s1.length();
    int m = s2.length();

    while (n > 0 && m > 0) {
      if (s1.charAt(n-1) == s2.charAt(m-1)) {
        sb.append(s1.charAt(n-1));
        n--;
        m--;
      } else if (dp[n - 1][m] >= dp[n][m]) {
        n--;
      } else {
        m--;
      }
    }
    return sb.reverse().toString();
  }
}
