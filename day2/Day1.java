import java.awt.image.DirectColorModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class Main {

  public static void main(String[] args) {
    ArrayList<String[]> ranges = readInput();
    ranges.stream().forEach(r -> System.out.println(r[0] + " - " + r[1]));

    ArrayList<String> badCodes = new ArrayList<String>();

    // split string in half, if odd do nothing, if both halves are the same add to list
    for (String[] r : ranges) {
      for (long i = Long.parseLong(r[0]); i <= Long.parseLong(r[1]); i++){
        String code = String.valueOf(i);
        if (code.length() % 2 == 0) {
          int midpoint = code.length() / 2;
          String half1 = code.substring(0, midpoint);
          String half2 = code.substring(midpoint);
          System.out.println(half1 + " and " + half2);
          if (half1.equals(half2)){
            badCodes.add(code);
            System.out.println("Range: " + r[0] + " - " + r[1] + "\nCode: " + code + "\n");
          }
        }
      }
    }
    Long finalNum = 0L;
    for (String b: badCodes) {
      finalNum+= Long.parseLong(b);
    }
    System.out.println(finalNum);
  }

  public static ArrayList<String[]> readInput(){
    String filePath = "input";
    ArrayList<String[]> ranges = new ArrayList<String[]>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line = reader.readLine();
      String[] sl = line.split(",");
      for (String s : sl) {
        ranges.add(s.split("-"));
      }

    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
    return ranges;
  }
}

