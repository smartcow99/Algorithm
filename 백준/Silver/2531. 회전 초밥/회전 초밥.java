import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, d, k, c;
    static int[] susi, eat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        susi = new int[n];
        eat = new int[d+1];
        for(int i=0; i<n; i++) {
            susi[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;

        for(int i=0; i<k; i++) {
            if(eat[susi[i]] == 0) {
                cnt++;
            }
            eat[susi[i]]++;
        }
        int maxlength = cnt;

        for(int i=1; i<n; i++) {
            if(maxlength <= cnt) {
                if(eat[c] == 0) {
                    maxlength = cnt+1;
                }
                else {
                    maxlength = cnt;
                }
            }

            int end = (i + k - 1) % n;

            if(eat[susi[end]] == 0) {
                cnt++;
            }

            eat[susi[end]]++;

            eat[susi[i-1]]--;

            if(eat[susi[i-1]] == 0) {
                cnt--;
            }
        }
        System.out.println(maxlength);
    }
}

