import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        N = Integer.parseInt(str);
        cycle(N);
        System.out.println(cnt);

    }
    static int N;
    static int cnt = 0;
    public static void cycle(int x) {
        int a, b;
        cnt++;
        if(x == 0) {
            return;
        }
        else if(x < 10) {
            a = 0;
            b = x % 10;
            b = b*10 + (a+b)%10;
            if(b == N) {
                return;
            }
            else {
                cycle(b);
            }

        }
        else {
            a = (int) x / 10;
            b = x % 10;
            b = b*10 + (a+b)%10;
            if(b == N) {
                return;
            }
            else {
                cycle(b);
            }
        }
    }
}