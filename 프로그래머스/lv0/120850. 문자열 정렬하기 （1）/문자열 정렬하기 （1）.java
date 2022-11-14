import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        String str = "";
        
        int l = my_string.length();
        for(int i=0; i<l; i++) {
            if(my_string.charAt(i) >= '0')
                if(my_string.charAt(i) <= '9')
                    str += my_string.charAt(i);
        }
        int[] answer = new int[str.length()];
        for(int i=0; i<str.length(); i++) {
            answer[i] = str.charAt(i) - '0';
        }
        Arrays.sort(answer);
        return answer;
    }
}