import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int size = elements.length;
        int[] numbers = new int[size * 2 - 1];
        for (int i = 0; i < size * 2 - 1; i++) {
            numbers[i] = elements[i%size];
        }
        
        Set<Integer> s = new HashSet<>();
        
        for (int l = 1; l <= size; l++) {
            int sum = 0;
            
            for (int i = 0; i < l; i++) {
                sum += numbers[i];
            }
            
            s.add(sum);
            
            for (int i = 1; i < size; i++) {
                sum = sum - numbers[i - 1] + numbers[i + l - 1];
                s.add(sum);
            }
        }
        return s.size();
    }
}