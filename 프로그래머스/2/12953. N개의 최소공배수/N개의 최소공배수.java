import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        int a = 0, b = 0;
        for(int i=1; i<arr.length; i++) {
            if (answer > arr[i]) {
                a = answer;
                b = arr[i];
            } else {
                a = arr[i];
                b = answer;
            }
            answer = lcm(a, b);
        }
        return answer;
    }
    
    public int gcd(int a, int b) {
        int r = 0;
        while(a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return b;
    }
    
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}