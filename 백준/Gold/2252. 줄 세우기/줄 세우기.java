import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n+1];
        List<List<Integer>> arr = new ArrayList<List<Integer>>();

        for(int i=0; i<n+1; i++)
            arr.add(new ArrayList<Integer>());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.get(x).add(y);
            indegree[y]++;
        }
        topologicalSort(indegree, arr);
    }
    static void topologicalSort(int[] indegree, List<List<Integer>> arr) {
        Queue<Integer> que = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<n+1; i++)
            if(indegree[i] == 0)
                que.offer(i);
        while(!que.isEmpty()) {
            int node = que.poll();
            result.offer(node);

            for(Integer i : arr.get(node)) {
                indegree[i]--;

                if(indegree[i] == 0) {
                    que.offer(i);
                }
            }
        }
        while(!result.isEmpty())
            sb.append(result.poll()).append(" ");
        System.out.println(sb);
    }
}

