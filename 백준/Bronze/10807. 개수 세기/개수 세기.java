import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr;
        arr = new int[201];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken()) + 100;
            arr[tmp] += 1;
        }
        int V = Integer.parseInt(br.readLine());
        System.out.println(arr[V+100]);
    }
}
