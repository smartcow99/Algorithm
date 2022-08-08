import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] tris;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        tris = new long[101];
        tris[1] = 1;
        tris[2] = 1;
        tris[3] = 1;
        tris[4] = 2;
        tris[5] = 2;
        tris[6] = 3;

        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(tri(N)).append("\n");
        }
        System.out.println(sb);
    }

    static long tri(int x) {
        if(tris[x] == 0) {
            tris[x] = tri(x-1) + tri(x-5);
        }
        return tris[x];
    }

}