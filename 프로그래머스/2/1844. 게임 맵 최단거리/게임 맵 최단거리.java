import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] mX = new int[] {1, 0, -1, 0};
        int[] mY = new int[] {0, 1, 0, -1};
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        result[0][0] = 1;
        
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0, 0));
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nX = cur.x + mX[i];
                int nY = cur.y + mY[i];
                
                if (nX < 0 || nY < 0 || nX >= n || nY >= m) continue;
                if (maps[nX][nY] == 0) continue;
                if (result[nX][nY] > result[cur.x][cur.y] + 1) {
                    result[nX][nY] = result[cur.x][cur.y] + 1;
                    q.offer(new Pos(nX, nY));
                }
            }
        }
        
        return result[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : result[n - 1][m - 1];
    }
    class Pos {
        int x;
        int y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}