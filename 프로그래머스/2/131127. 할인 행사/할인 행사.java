import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < number.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        if (wantMap.equals(discountMap)) answer++;
        for (int i = 10; i < discount.length; i++) {
            String bef = discount[i-10];
            String nxt = discount[i];
            discountMap.put(bef, discountMap.getOrDefault(bef, 0) - 1);
            if (discountMap.get(bef) == 0) {
                discountMap.remove(bef);
            }
            
            discountMap.put(nxt, discountMap.getOrDefault(nxt, 0) + 1);
            if (wantMap.equals(discountMap)) answer++;
        }
        return answer;
    }
}