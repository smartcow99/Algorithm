import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class tomato {
        int x;
        int y;

        tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Queue<tomato> reds = new LinkedList<>();
        int greens = 0;
        int days = 0;
        box = new int[M][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                box[x][y] = Integer.parseInt(st.nextToken());
                if(box[x][y] == 0) greens++;
                else if(box[x][y] == 1) reds.add(new tomato(x, y));
            }
        }

        while(greens > 0 && !reds.isEmpty()) {
            int size = reds.size();
            for(int i=0; i<size; i++) {
                tomato tmt = reds.remove();
                int x = tmt.x;
                int y = tmt.y;

                for(int j=0; j<4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                    if(box[nx][ny] != 0) continue;
                    greens--;
                    box[nx][ny] = 1;
                    reds.add(new tomato(nx, ny));
                }
            }
            days++;
        }
        if(greens == 0) {
            System.out.println(days);
        }
        else {
            System.out.println(-1);
        }

    }
}