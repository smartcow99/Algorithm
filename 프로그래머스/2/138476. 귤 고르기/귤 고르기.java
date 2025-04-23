import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int tanger : tangerine) {
            countMap.put(tanger, countMap.getOrDefault(tanger, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort((a, b) -> b - a);
        
        int cnt = 0;
        int types = 0;
        
        for (int count : counts) {
            cnt += count;
            types++;
            
            if (cnt >= k) {
                break;
            }
        }
        
        return types;
    }
}