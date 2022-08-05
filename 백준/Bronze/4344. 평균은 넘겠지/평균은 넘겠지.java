import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int C = Integer.parseInt(str);
        for(int i=0; i<C; i++) {
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            ArrayList<Integer> scores = new ArrayList<>();
            int N = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                scores.add(Integer.parseInt(st.nextToken()));
            }
            int sum = 0;
            int cnt = 0;
            for(int num : scores) {
                sum += num;
            }
            double av = sum / N;

            for(int num : scores) {
                if(num > av) {
                    cnt++;
                }
            }

            double per = (double)cnt / (double)N;

            System.out.println(String.format("%.3f", per*100) + "%");

        }



    }
}