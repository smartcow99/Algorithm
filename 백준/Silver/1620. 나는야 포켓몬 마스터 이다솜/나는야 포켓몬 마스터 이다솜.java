import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// HASH
// 나는야 포켓몬 마스터 이다솜
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
        String[] nameArr = new String[N + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < N + 1; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            nameArr[i] = name;
        }

        while(M-- > 0) {
            String findStr = br.readLine();
            if(isStringNumber(findStr)) {
                int index = Integer.parseInt(findStr);
                sb.append(nameArr[index]);
            }
            else {
                sb.append(nameMap.get(findStr));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isStringNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}