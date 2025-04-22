class Solution {
    public int solution(int n) {
        int one = checkOne(n);
        int answer = n+1;
        
        while(true) {
            if(one == checkOne(answer)) return answer;
            answer++;
        }
    }
    
    public int checkOne(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i< s.length(); i++) {
            if(s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}