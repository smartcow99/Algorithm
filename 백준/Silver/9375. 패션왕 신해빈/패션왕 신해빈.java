import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            HashMap<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            for (int x = 0; x < N; x++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();

                if (map.containsKey(kind)) {
                    map.put(kind, map.get(kind) + 1);
                } else {
                    map.put(kind, 1);
                }
            }
            int result = 1;

            for (Integer x : map.values()) {
                result *= (x + 1);
            }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }
}