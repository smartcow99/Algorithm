import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            char[][] ttt = new char[3][3];

            // end 입력 받은 경우 종료
            if (str.charAt(0) == 'e') break;

            for (int i = 0; i < 9; i++)
                ttt[i / 3][i % 3] = str.charAt(i);

            if (check(ttt))
                sb.append("valid").append("\n");
            else
                sb.append("invalid").append("\n");
        }
        System.out.println(sb);
    }

    static boolean check(char[][] ttt) {
        int oNum = 0, xNum = 0, dNum = 0;

        for (int i = 0; i < 9; i++) {
            if (ttt[i / 3][i % 3] == 'X') xNum++;
            else if (ttt[i / 3][i % 3] == 'O') oNum++;
            else dNum++;
        }
        // 그냥 끝난 상황 or X가 이긴 상황
        if (xNum + oNum == 9) {
            // 그냥 끝난 상황 || O가 이긴 상황
            if (xNum - 1 != oNum || isValid(ttt, 'O')) return false;
            else return true;
        } else {
            // O가 이긴 상황
            if (xNum == oNum) {
                boolean oWin = isValid(ttt, 'O');
                boolean xWin = isValid(ttt, 'X');
                if (oWin && !xWin) return true;
                else return false;
            }
            // X가 이긴 상황
            else if (xNum - 1 == oNum) {
                boolean oWin = isValid(ttt, 'O');
                boolean xWin = isValid(ttt, 'X');
                if (!oWin && xWin) return true;
                else return false;
            }
        }
        return false;
    }

    static boolean isValid(char[][] ttt, char c) {
        for (int i = 0; i < 3; i++)
            if (ttt[i][0] == c && ttt[i][1] == c && ttt[i][2] == c) return true;

        for (int i = 0; i < 3; i++)
            if (ttt[0][i] == c && ttt[1][i] == c && ttt[2][i] == c) return true;

        if (ttt[0][0] == c && ttt[1][1] == c && ttt[2][2] == c) return true;

        if (ttt[0][2] == c && ttt[1][1] == c && ttt[2][0] == c) return true;

        return false;
    }
}
