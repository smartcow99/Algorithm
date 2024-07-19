import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Top {
        int num, height;

        Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Top> top = new Stack<>();


        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if(top.isEmpty()) {
                sb.append("0 ");
                top.push(new Top(i, height));
            }
            else {
                while(true) {
                    if(top.isEmpty()) {
                        sb.append("0 ");
                        top.push(new Top(i, height));
                        break;
                    }
                    Top t = top.peek();

                    if(t.height > height) {
                        sb.append(t.num).append(" ");
                        top.push(new Top(i, height));
                        break;
                    }
                    else {
                        top.pop();
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}

