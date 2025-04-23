import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            if (used.contains(curr) || curr.charAt(0) != prev.charAt(prev.length() - 1)) {
                int who = (i % n) + 1;
                int when = (i / n) + 1;
                return new int[]{who, when};
            }

            used.add(curr);
        }

        return new int[]{0, 0};
    }
}
