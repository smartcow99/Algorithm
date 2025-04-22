class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while(s.length() > 1) {
            int n = s.length();
            char[] c = s.toCharArray();
            for (char num : c) {
                if(num == '0') {
                    answer[1]++;
                    n--;
                }
            }
            s = Integer.toBinaryString(n);
            answer[0]++;
        }
        return answer;
    }
}