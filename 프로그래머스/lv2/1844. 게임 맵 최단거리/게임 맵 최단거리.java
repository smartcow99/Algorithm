import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] maps) throws IOException {
        int n = maps.length;
        int m = maps[0].length;
        int[][] visited = new int[n][m];
        
        visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.remove();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || nx > n-1 || ny < 0 || ny > m -1)
                    continue;
                if(visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        int answer = visited[n-1][m-1];
        if(answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
}