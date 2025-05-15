import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int idx = 0;
        int nowWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        while (idx < truck_weights.length) {
            time++;
            
            nowWeight -= bridge.poll();
            
            if (weight >= nowWeight + truck_weights[idx]) {
                bridge.add(truck_weights[idx]);
                nowWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }
        time += bridge_length;
        
        return time;
    }
}