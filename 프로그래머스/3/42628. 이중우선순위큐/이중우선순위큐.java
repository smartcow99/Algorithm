import java.util.PriorityQueue;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;

        for (String operation : operations) {
            String[] ops = operation.split(" ");
            int num = Integer.parseInt(ops[1]);

            if (ops[0].equals("I")) {
                minPQ.add(num);
                maxPQ.add(num);
                count++;
            } else if (ops[0].equals("D")) {
                if (count == 0) continue;
                
                if (num == 1) {
                    minPQ.remove(maxPQ.poll());
                } else {
                    maxPQ.remove(minPQ.poll());
                }
                count--;
            }
        }

        if (count == 0) return new int[]{0, 0};

        int max = maxPQ.poll();
        int min = minPQ.poll();

        return new int[]{max, min};
    }
}
