import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");
            int[] students = new int[20];

            int cnt = 0;
            for (int x = 0; x < students.length; x++) {
                students[x] = Integer.parseInt(st.nextToken());
            }
            for (int x = 0; x < students.length; x++) {
                for (int y = 0; y < x; y++) {
                    if (students[y] > students[x]) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}