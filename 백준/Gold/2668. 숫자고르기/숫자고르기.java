import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    static boolean[] flags;
    static int[] arr;
    static ArrayList results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 입력 저장 배열
        arr = new int[N + 1];

        // 방문 결과 저장 배열
        flags = new boolean[N + 1];

        // 결과 저장할 리스트
        results = new ArrayList<>();

        // 입력 받기
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // dfs 사용
        for (int i = 1; i < N + 1; i++) {
            // i 방문
            flags[i] = true;
            dfs(i, i);
            // i 방문 취소
            flags[i] = false;
        }

        Collections.sort(results);
        sb.append(results.size()).append("\n");

        for(int i=0; i<results.size(); i++) {
            sb.append(results.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int s, int t) {

        // arr[i]에 있는 숫자를 방문 했는지 확인
        // 방문하지 않았다면 방문
        // 만약 방문했다면? 사이클이 돈거임
        if (!flags[arr[s]]) {
            flags[arr[s]] = true;
            // 방문 후 다음 숫자 찾아 떠나기
            dfs(arr[s], t);
            // 방문 취소
            flags[arr[s]] = false;
        }
        // 만약 s가 t와 같다면 이자식 검거 완료
        if (arr[s] == t) results.add(t);

    }


}