import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());


        int graph[][] = new int[N+1][N+1];
        boolean flags[] = new boolean[N+1];

        for(int i=0; i<C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        dfs(1, flags, graph);
        System.out.println(cnt-1);
    }
    static void dfs(int v, boolean[] flags, int[][] graph) {
        if(flags[v] == true) return;

        flags[v] = true;
        cnt++;

        for(int i=0; i<graph[v].length; i++) {
            if(graph[v][i] == 1 && !flags[i]) {
                dfs(i, flags, graph);
            }
        }
    }

}