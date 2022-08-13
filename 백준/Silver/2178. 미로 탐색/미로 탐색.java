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

    static int[] dx;

    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        flags = new boolean[n][m];
        flags[0][0] = true;
        que = new LinkedList<>();

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};

        for (int x = 0; x < n; x++) {
            String str = br.readLine();
            for (int y = 0; y < m; y++) {
                map[x][y] = str.charAt(y) - '0';
            }
        }
        que.offer(new Pair(0, 0));

        while(!que.isEmpty()) {
            Pair p = que.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if(flags[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }

                que.offer(new Pair(nx, ny));
                map[nx][ny] = map[p.x][p.y] + 1;
                flags[nx][ny] = true;
            }
        }
        System.out.println(map[n-1][m-1]);
    }


    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

