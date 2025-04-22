import java.util.*;

class Solution {
    public String solution(String s) {
        String[] ss = s.split(" ");
        int n = ss.length;
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append(" ").append(nums[n-1]);
        return sb.toString();
    }
}