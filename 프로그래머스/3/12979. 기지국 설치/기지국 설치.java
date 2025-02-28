class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int pos = 1;
        int idx = 0;
        int range = 2 * w + 1;

        while (pos <= n) {
            if (idx < stations.length && stations[idx] - w <= pos) {
                pos = stations[idx] + w + 1;
                idx++;
            } else {
                answer++;
                pos += range;
            }
        }

        return answer;
    }
}
