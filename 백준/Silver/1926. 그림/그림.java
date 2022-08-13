import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int[][] pictures;
    static boolean[][] flags;
    static Queue<Pair> que;

    static int[] dx;

    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        pictures = new int[n][m];
        flags = new boolean[n][m];
        que = new LinkedList<>();

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) {
                pictures[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int size;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pictures[i][j] == 0 || flags[i][j]) {
                    continue;
                }
                
                cnt++;
                que.offer(new Pair(i, j));
                flags[i][j] = true;

                size = 0;

                while (!que.isEmpty()) {
                    Pair pa = que.poll();
                    size++;
                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + pa.x;
                        int ny = dy[k] + pa.y;

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            continue;
                        }
                        if (pictures[nx][ny] == 1 && !flags[nx][ny]) {
                            que.offer(new Pair(nx, ny));
                            flags[nx][ny] = true;
                        }
                    }
                }
                if (size > max) {
                    max = size;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }


    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

