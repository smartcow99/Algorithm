import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int speedLimit = Integer.parseInt(br.readLine());
    int actualSpeed = Integer.parseInt(br.readLine());

    int overSpeed = actualSpeed - speedLimit;

    if (overSpeed <= 0) {
      System.out.println("Congratulations, you are within the speed limit!");
    } else if (overSpeed <= 20) {
      System.out.println("You are speeding and your fine is $100.");
    } else if (overSpeed <= 30) {
      System.out.println("You are speeding and your fine is $270.");
    } else {
      System.out.println("You are speeding and your fine is $500.");
    }
  }
}
