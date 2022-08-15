import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] map;
    static boolean[][] flags;
    static Queue<Pair> que;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int t, n, m, k, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            flags = new boolean[n][m];
            cnt = 0;

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (!flags[x][y] && map[x][y] == 1) {
                        cnt++;
                        bfs(x, y);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        que = new LinkedList<>();

        que.offer(new Pair(x, y));

        while (!que.isEmpty()) {
            flags[x][y] = true;
            Pair p = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (!flags[nx][ny] && map[nx][ny] == 1) {
                    que.offer(new Pair(nx, ny));
                    flags[nx][ny] = true;
                }
            }
        }
    }

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

