import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1);
        }
        
        for (String key : map.keySet()) {
            int value = map.get(key);
            answer *= value;
        }
        return answer - 1;
    }
}