import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for(int i=1; i<N+1; i++) {
            parents[i] = i;
        }

        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        int cnt = 0;
        int root = find(1);

        for(int i=2; i<N+1; i++) {
            if(find(i) == root)
                cnt++;
        }
        System.out.println(cnt);
    }
    static void union(int x, int y) {
        x =find(x);
        y = find(y);

        if(x != y)
            parents[y] = x;
    }
    static int find(int x) {
        if(x == parents[x])
            return x;

        int root = find(parents[x]);
        parents[x] = root;
        return root;
    }
}

