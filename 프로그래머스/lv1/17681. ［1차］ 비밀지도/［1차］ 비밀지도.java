import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        List<String> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String tmp = "";
            for(int j=0; j<n; j++) {
                int div = (int) Math.pow(2, n-1-j);
                if(arr1[i] / div == 1 || arr2[i] / div == 1) {
                    tmp = tmp.concat("#");
                }
                else {
                    tmp = tmp.concat(" ");
                }
                arr1[i] = arr1[i] % div;
                arr2[i] = arr2[i] % div;
            }
            ans.add(tmp);
        }

        String[] answer = ans.toArray(new String[0]);
        return answer;
    }
}