import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = {
            {3, 1}, 
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0},        {3, 2}
        };


        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};

        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            int[] pos = keypad[num];

            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPos = pos;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPos = pos;
            } else {
                int leftDist = Math.abs(pos[0] - leftPos[0]) + Math.abs(pos[1] - leftPos[1]);
                int rightDist = Math.abs(pos[0] - rightPos[0]) + Math.abs(pos[1] - rightPos[1]);

                if (leftDist < rightDist) {
                    sb.append("L");
                    leftPos = pos;
                } else if (rightDist < leftDist) {
                    sb.append("R");
                    rightPos = pos;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftPos = pos;
                    } else {
                        sb.append("R");
                        rightPos = pos;
                    }
                }
            }
        }

        return sb.toString();
    }
}
