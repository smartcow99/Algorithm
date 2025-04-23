import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        Deque<Integer> deq = new LinkedList<>();
        for (int p : people) {
            deq.add(p);
        }

        while (!deq.isEmpty()) {
            int lightest = deq.peekFirst();
            int heaviest = deq.peekLast();

            if (lightest + heaviest <= limit) {
                deq.pollFirst();
            }
            deq.pollLast();
            count++;
        }

        return count;
    }
}
