import java.util.*;
class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int l = array.length / 2;
        int answer = array[l];
        return answer;
    }
}