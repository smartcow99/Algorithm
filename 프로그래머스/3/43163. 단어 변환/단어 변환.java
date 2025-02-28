import java.util.HashSet;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;


class Pair {
    String left;
    Integer right;
    
    Pair(String left, Integer right) {
        this.left = left;
        this.right = right;
    }
    
    public String getLeft() {
        return this.left;
    }
    
    public Integer getRight() {
        return this.right;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        
        HashSet<String> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, 0));
        
        while (!q.isEmpty()) {
            Pair tmp = q.poll();
            String cur = tmp.getLeft();
            Integer depth = tmp.getRight();
            
            if (cur.equals(target)) return depth;
            
            for (String word : words) {
                if (!visited.contains(word) && check(cur, word)) {
                    visited.add(word);
                    q.offer(new Pair(word, depth + 1));
                }
            }
        }
        return 0;
    }
    
    public static boolean check(String begin, String target) {
        int cnt = 0;
        for (int i=0; i<begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
}