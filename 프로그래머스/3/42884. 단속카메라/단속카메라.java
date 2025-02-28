import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int camera = routes[0][1];
        
        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}