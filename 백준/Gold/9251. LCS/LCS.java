import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static char[] c1, c2;
  static int[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();
    int s1Length = s1.length();
    int s2Length = s2.length();

    c1 = new char[s1Length + 1];
    c2 = new char[s2Length + 1];

    for (int i = 1; i <= s1Length; i++) {
      c1[i] = s1.charAt(i - 1);
    }
    for (int i = 1; i <= s2Length; i++) {
      c2[i] = s2.charAt(i - 1);
    }

    dp = new int[s1Length + 1][s2Length + 1];

    for (int i = 1; i <= s1Length; i++) {
      for (int j = 1; j <= s2Length; j++) {
        if (c1[i] == c2[j]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    System.out.println(dp[s1Length][s2Length]);
  }
}
