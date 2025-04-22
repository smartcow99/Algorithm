class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        int n = s.length();
        
        for (int i=0; i<n; i++) {
            if ('(' == s.charAt(i)) {
                cnt++;
            } else {
                if (cnt <= 0) return false;
                cnt--;
            }
        }
        if (cnt != 0) return false;
        return answer;
    }
}