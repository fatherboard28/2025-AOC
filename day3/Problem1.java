import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Problem1 {

  public static void main(String[] args) {
    ArrayList<int[]> lines = readInput();

    Long total = 0L;
    for (int[] line : lines) {
      String voltage = findVoltage(line, -1, "");
      total += Long.parseLong(voltage);
    }

    System.out.println(total);
  }

  public static String findVoltage(int[] line, int prevIndex, String finalNum){
    if (finalNum.length() == 12){
      return finalNum;
    }

    int nextNum = 0;
    int nextNumIndex = 0;
    int endIndex = finalNum.length()-11+line.length;

    for(int i = prevIndex+1; i < endIndex; i++) {
      if (nextNum < line[i]) {
        nextNum = line[i];
        nextNumIndex = i;
      }
    }

    finalNum += String.valueOf(nextNum);
    return findVoltage(line, nextNumIndex, finalNum);
  }

  public static ArrayList<int[]> readInput(){
    String filePath = "input";
    ArrayList<int[]> lines = new ArrayList<int[]>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        int[] intLine = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
          intLine[i] = Integer.parseInt(String.valueOf(line.charAt(i)));
        }
        lines.add(intLine);
      }

    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
    return lines;
  }
}

