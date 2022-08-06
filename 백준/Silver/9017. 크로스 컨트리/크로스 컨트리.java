import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 입력 받은 N개의 정수
            ArrayList<Integer> scores = new ArrayList<>();

            // 통과한 팀 리스트
            ArrayList<Integer> teams = new ArrayList<>();

            // 최대 200팀의 점수를 저장할 리스트
            int[][] ts;
            ts = new int[201][];

            // scores 데이터 저장
            while (st.hasMoreTokens()) {
                scores.add(Integer.parseInt(st.nextToken()));
            }

            // 탈락한 팀 제거 and team 데이터 저장
            for (int x = 1; x < 201; x++) {
                if (Collections.frequency(scores, Integer.valueOf(x)) < 6) {
                    while (scores.contains(Integer.valueOf(x))) {
                        scores.remove(Integer.valueOf(x));
                    }
                } else {
                    teams.add(x);
                }
            }

            // min, minIndex 선언
            int min = 1200;
            int minIndex = 1;

            for (Integer x : teams) {
                int[] tmp;
                tmp = new int[Collections.frequency(scores, Integer.valueOf(x))];
                int tmpSum = 0;
                int index = 0;
                for (int y = 0; y < scores.size(); y++) {
                    if (scores.get(y).equals(x)) {
                        tmp[index++] = y + 1;
                    }
                }

                // 성공한 팀원의 index+1 ts에 저장
                ts[x] = tmp;

                // 1등부터 4등까지 tmpSum
                for(int o=0; o<4; o++) {
                    tmpSum += tmp[o];
                }

                // 점수를 비교해 우승팀 구하기
                if (min > tmpSum) {
                    min = tmpSum;
                    minIndex = x;
                }

                // 점수가 같은 경우 5번째 팀원의 점수로 비교
                else if (min == tmpSum) {
                    if (ts[x][4] < ts[minIndex][4]) {
                        minIndex = x;
                    }
                }
            }
            System.out.println(minIndex);
        }
    }


}