import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int n;
  static List<int[]> tree;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    tree = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      tree.add(new int[]{-1, -1});
    }

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char mother = st.nextToken().charAt(0);
      int motherIndex = mother - 'A'; // A = 0, B = 1, C = 2 ...

      char leftChild = st.nextToken().charAt(0);
      char rightChild = st.nextToken().charAt(0);

      if (leftChild != '.') {
        tree.get(motherIndex)[0] = leftChild - 'A';
      }
      if (rightChild != '.') {
        tree.get(motherIndex)[1] = rightChild - 'A';
      }
    }

    // 전위 순회
    preOrder(0);
    sb.append('\n');
    // 중위 순회
    inOrder(0);
    sb.append('\n');
    // 후위 순회
    postOrder(0);
    sb.append('\n');

    System.out.print(sb);
  }

  static void preOrder(int node) {
    if (node == -1) return;
    sb.append((char) (node + 'A'));
    preOrder(tree.get(node)[0]);
    preOrder(tree.get(node)[1]);
  }

  static void inOrder(int node) {
    if (node == -1) return;
    inOrder(tree.get(node)[0]);
    sb.append((char) (node + 'A'));
    inOrder(tree.get(node)[1]);
  }

  static void postOrder(int node) {
    if (node == -1) return;
    postOrder(tree.get(node)[0]);
    postOrder(tree.get(node)[1]);
    sb.append((char) (node + 'A'));
  }
}
