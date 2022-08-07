import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[][] dp = new Integer[41][2];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;


        for(int i=0; i<testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            func(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.println(sb);
    }

    static Integer[] func(int x) {
        if(dp[x][0] == null || dp[x][1] == null) {
            dp[x][0] = func(x-1)[0] + func(x-2)[0];
            dp[x][1] = func(x-1)[1] + func(x-2)[1];
        }

        return dp[x];
    }
}