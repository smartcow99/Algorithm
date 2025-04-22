class Solution {
    public int[] solution(int brown, int yellow) {
        int xy = brown + yellow;
        
        for(int y = 1; y <= Math.sqrt(xy); y++) {
            if (xy % y != 0) continue;
            int x = xy / y;
            
            if((x - 2) * (y - 2) == yellow) {
                return new int[]{x, y};
            }
        }
        return new int[]{0, 0};
    }
}