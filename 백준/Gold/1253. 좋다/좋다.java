import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        for(int i=0; i<N; i++) {
            int r = N-1;
            int l = 0;
            while(true) {
                
                if(l == i) {
                    l++;
                }
                else if(r == i) {
                    r--;
                }
                if(r <= l) {
                    break;
                }
                if(arr[l] + arr[r] < arr[i]) {
                    l++;
                }
                else if(arr[l] + arr[r] > arr[i]) {
                    r--;
                }
                else {
                    cnt++;
                    break;
                }

            }
        }
        System.out.println(cnt);
    }
}