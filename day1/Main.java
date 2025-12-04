import java.awt.image.DirectColorModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class Main {

  public static void main(String[] args) {
    Stack<Dirrection> input = readInput();
    int currentPos = 50;
    int count = 0;

    for (Dirrection d : input) {
      int tmpA = d.amount;
      if (d.direction == 'R'){
        while (tmpA > 0){
          currentPos += 1;

          if (currentPos == 100) {
            currentPos = 0;
            count++;
          }
          tmpA--;
        }
        System.out.println(currentPos);
      }else{
        while (tmpA > 0){
          currentPos -= 1;

          if (currentPos == -1){
            currentPos = 99;
          }
          if (currentPos == 0){
            count++;
          }
          tmpA--;
        }
        System.out.println(currentPos);
      }

    }
    System.out.println(count);
  }

  public static Stack<Dirrection> readInput(){
    String filePath = "input";
    Stack<Dirrection> output = new Stack();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        output.add(new Dirrection(
              line.toCharArray()[0], 
              Integer.parseInt(String.valueOf(Arrays.copyOfRange(line.toCharArray(), 1, line.length())))
              )
            );
      }
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
    return output;
  }

  public static class Dirrection{
    char direction;
    int amount;

    public Dirrection(char d, int a){
      direction = d;
      amount = a;
    }

    @Override
    public String toString(){
      return "Direction: " + direction + " Amount: " + amount + ".\n";
    }
  }
}

