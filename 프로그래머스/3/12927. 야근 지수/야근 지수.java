import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int work : works) {
            pq.add(work);
        }

        while (n > 0 && !pq.isEmpty()) {
            int high = pq.poll();
            if (high == 0) break;
            pq.add(high - 1);
            n--;
        }

        while (!pq.isEmpty()) {
            int tmp = pq.poll();
            answer += (long) tmp * tmp;
        }

        return answer;
    }
}
