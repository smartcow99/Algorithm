import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int[][] sudoku = new int[9][9];
  public static ArrayList<int[]> blanks = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 9; i++) {
      char[] arr = br.readLine().toCharArray();
      for (int j = 0; j < 9; j++) {
        sudoku[i][j] = arr[j] - '0';
        if (sudoku[i][j] == 0) {
          blanks.add(new int[]{i, j});
        }
      }
    }

    solve(0);
  }

  public static boolean isValid(int x, int y, int num) {
    for (int i = 0; i < 9; i++) {
      if (sudoku[x][i] == num) return false;
      if (sudoku[i][y] == num) return false;
    }

    int startX = (x / 3) * 3;
    int startY = (y / 3) * 3;
    for (int i = startX; i < startX + 3; i++) {
      for (int j = startY; j < startY + 3; j++) {
        if (sudoku[i][j] == num) return false;
      }
    }

    return true;
  }

  public static boolean solve(int depth) {
    if (depth == blanks.size()) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          System.out.print(sudoku[i][j]);
        }
        System.out.println();
      }
      return true;
    }

    int[] pos = blanks.get(depth);
    int x = pos[0];
    int y = pos[1];

    for (int num = 1; num <= 9; num++) {
      if (isValid(x, y, num)) {
        sudoku[x][y] = num;
        if (solve(depth + 1)) return true;
        sudoku[x][y] = 0;
      }
    }

    return false;
  }
}
