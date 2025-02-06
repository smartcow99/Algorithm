import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\-");
        List<Integer> numbers = new ArrayList<>();
        
        for(int i=0; i<input.length; i++) {
            String[] num = input[i].split("\\+");
            int tmp = 0;
            for(int j=0; j<num.length; j++) {
                tmp += Integer.parseInt(num[j]);
            }
            numbers.add(tmp);
        }
        int result = (int)numbers.get(0);
        for(int i=1; i<numbers.size(); i++) {
            result -= (int)numbers.get(i);
        }
        System.out.println(result);
    }
}
