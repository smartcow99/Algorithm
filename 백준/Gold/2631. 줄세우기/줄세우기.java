import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] inputs;
        inputs = new int[N];

        for(int i=0; i<N; i++) inputs[i] = Integer.parseInt(br.readLine());

        // 증가하는 수의 최대 길이 저장
        int[] dp = new int[N];
        dp[0] = 1;

        int result = 0;

        for(int i=1; i<N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(inputs[i] > inputs[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1 );
                }
                result = Math.max(result, dp[i]);
            }
        }
        System.out.println(N - result);
    }


}