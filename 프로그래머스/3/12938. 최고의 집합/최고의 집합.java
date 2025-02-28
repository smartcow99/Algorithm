import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] answer = new int [n];
        int num = s / n + 1;
        Arrays.fill(answer, num);
        int dif = n * num - s;
        for (int i=0; i < dif; i++) {
            answer[i]--;
        }
        return answer;
    }
}