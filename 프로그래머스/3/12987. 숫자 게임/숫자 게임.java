import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqB = new PriorityQueue<>((a, b) -> b - a);
        int answer = 0;
        
        for (int i = 0; i<A.length; i++) {
            pqA.add(A[i]);
            pqB.add(B[i]);
        }
        
        while (!pqA.isEmpty() && !pqB.isEmpty()) {
            int a = pqA.poll();
            int b = pqB.poll();
            
            if (b > a) {
                answer++;
            } else {
                pqB.add(b);
            }
        }
        
        
        return answer;
    }
}