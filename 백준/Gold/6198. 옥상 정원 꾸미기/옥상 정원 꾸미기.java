import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }

            stk.push(arr[i]);
            result += stk.size()-1;
        }

        System.out.println(result);
    }
}

