import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long[] arr;
        arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            arr[i] = arr[i-1] + Long.parseLong(st.nextToken());
        }
        int l = 1;
        int r = 1;
        long result = 987654321;
        while(true) {

            if(S <= arr[r] - arr[l-1]) {
                result = Math.min(result, r-l+1);
                l++;
            }
            else {
                r++;
            }
            if(r > N) {
                break;
            }
        }
        if(result == 987654321) {
            System.out.println(0);
        }
        else {
            System.out.println(result);
        }

    }
}