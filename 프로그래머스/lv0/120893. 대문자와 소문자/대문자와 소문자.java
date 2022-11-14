class Solution {
    public String solution(String my_string) {
        String answer = "";
        int l = my_string.length();
        for(int i=0; i<l; i++) {
            if(my_string.charAt(i) > 96)
                answer += (char)(my_string.charAt(i) - ' ');
            else
                answer += (char)(my_string.charAt(i) + ' ');
        }
        return answer;
    }
}