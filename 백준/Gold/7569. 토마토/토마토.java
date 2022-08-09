import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;
    static int H;
    static int[][][] box;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static class Tomatoes {
        int x;
        int y;
        int z;

        Tomatoes(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Queue<Tomatoes> red = new LinkedList<>();
        box = new int[M][N][H];

        int green = 0;
        int days = 0;

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[x][y][z] = Integer.parseInt(st.nextToken());
                    if (box[x][y][z] == 1) {
                        red.add(new Tomatoes(x, y, z));
                    } else if (box[x][y][z] == 0) {
                        green++;
                    }
                }
            }
        }

        while (green > 0 && !red.isEmpty()) {
            int size = red.size();
            for (int i = 0; i < size; i++) {
                Tomatoes ts = red.remove();
                int x = ts.x;
                int y = ts.y;
                int z = ts.z;

                for (int j = 0; j < 6; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nz = z + dz[j];

                    if (nz < 0 || ny < 0 || nx < 0 || nz >= H || ny >= N || nx >= M) {
                        continue;
                    }
                    if (box[nx][ny][nz] != 0) {
                        continue;
                    }
                    green--;
                    box[nx][ny][nz] = 1;
                    red.add(new Tomatoes(nx, ny, nz));
                }
            }
            days++;
        }
        if (green == 0) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
}