import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] countries = new int[N+1][4];
        int[] rank;
        rank = new int[1001];
        int[] total = new int[1001];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            countries[i][0] = Integer.parseInt(st.nextToken());
            countries[i][1] = Integer.parseInt(st.nextToken());
            countries[i][2] = Integer.parseInt(st.nextToken());
            countries[i][3] = Integer.parseInt(st.nextToken());
            total[countries[i][0]] = countries[i][1] * 1000001 + countries[i][2] * 1001 + countries[i][3];
        }
        for (int i = 1; i < N+1; i++) {
            for (int j=1; j < N+1; j++) {
                if(total[i] < total[j]) {
                    rank[i] += 1;
                }
            }
        }
        System.out.println(rank[K]+1);
    }


}