import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] house;
        house = new int[N];
        for(int i=0; i<N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        long top = house[N-1] - house[0];
        int result = 0;
        int bottom = 1;
        while(bottom <= top) {
            int mid = (int) ((top + bottom) / 2);
            int tmp = house[0];
            int cnt = 1;
            for(int i=1; i<N; i++) {
                int k = house[i] - tmp;
                if(mid <= k ) {
                    cnt++;
                    tmp = house[i];
                }
            }
            if(cnt >= C) {
                result = mid;
                bottom = mid+1;
            }
            else {
                top = mid - 1;
            }
        }
        System.out.println(result);


    }
}