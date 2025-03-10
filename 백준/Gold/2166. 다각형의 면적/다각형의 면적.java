import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    coordinate[] cords = new coordinate[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      cords[i] = new coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    double result = 0;
    for (int i = 0; i < n; i++) {
      int next = (i + 1) % n;
      result += (double) cords[i].x * cords[next].y;
      result -= (double) cords[next].x * cords[i].y;
    }

    System.out.printf("%.1f", Math.abs(result / 2));
  }

  public static class coordinate {
    int x;
    int y;

    public coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
