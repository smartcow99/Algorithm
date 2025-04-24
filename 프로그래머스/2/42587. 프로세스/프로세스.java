import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Process> deq = new ArrayDeque<>();
        int answer = 0;
        
        for (int i = 0; i < priorities.length; i++) {
            deq.offerLast(new Process(priorities[i], i));
        }
        
        while (!deq.isEmpty()) {
            int maxi = Integer.MIN_VALUE;
            for (Process pro : deq) {
                maxi = Math.max(pro.pri, maxi);
            }
            
            Process cur = deq.pollFirst();
            
            if (cur.pri == maxi) {
                answer++;
                if (cur.loc == location) break;
            } else {
                deq.offerLast(cur);
            }
        }
        
        return answer;
    }
    
    class Process {
        int pri;
        int loc;
        
        Process(int pri, int loc) {
            this.pri = pri;
            this.loc = loc;
        }
    }
}