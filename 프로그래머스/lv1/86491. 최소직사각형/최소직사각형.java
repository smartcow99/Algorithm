class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;
        for(int i=0; i<n; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        int max_h = 0;
        int max_w = 0;
        for(int i=0; i<n; i++) {
            max_w = Math.max(max_w, sizes[i][0]);
            max_h = Math.max(max_h, sizes[i][1]);
        }
        int answer = max_h * max_w;
        return answer;
        // 동해 캐뤼
    }
}