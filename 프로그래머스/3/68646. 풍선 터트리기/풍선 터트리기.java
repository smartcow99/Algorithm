class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] minL = new int[n];
        int[] minR = new int[n];
        
        int min = a[0];
        minL[0] = a[0];
        
        for (int i = 1; i < n; i++) {
            min = Math.min(min, a[i]);
            minL[i] = min;
        }
        
        min = a[n - 1];
        minR[n - 1] = a[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, a[i]);
            minR[i] = min;
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1 || a[i] < minL[i - 1] || a[i] < minR[i + 1]) {
                cnt++;
            }
        }
        return cnt;
    }
}