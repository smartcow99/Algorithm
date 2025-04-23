import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> deq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            deq.offerLast(c);
        }
        if(check(deq)) answer++;
        for (int i = 1; i < s.length(); i++) {
            deq.offerLast(deq.pollFirst());
            if(check(deq)) answer++;
        }
        return answer;
    }
    
    public boolean check(Deque<Character> dq) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : dq) {
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;

                char top = stk.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }
}