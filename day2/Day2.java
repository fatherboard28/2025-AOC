import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Day2 {

  public static void main(String[] args) {
    ArrayList<String[]> ranges = readInput();
    ranges.stream().forEach(r -> System.out.println(r[0] + " - " + r[1]));

    ArrayList<String> badCodes = new ArrayList<String>();

    for (String[] r : ranges) {
      System.out.println(r[0].length() + " " + r[1].length());
      for (long i = Long.parseLong(r[0]); i <= Long.parseLong(r[1]); i++){
        String code = String.valueOf(i);
        if (code.length() != 1 && analyze(code, code.length()/2, 2)){
          badCodes.add(code);
        }
      }
    }

    Long finalNum = 0L;
    for (String b: badCodes) {
      finalNum+= Long.parseLong(b);
    }
    System.out.println(finalNum);
  }

  public static boolean analyze(String code, int index, int n){
    if (index < 0 || index > code.length()) {
      return false;
    }
    if (n > code.length()) {
      return false;
    }

    return code.substring(0,index).repeat(n).equals(code) 
      || analyze(code, index-1, n+1) || analyze(code, index, n+1);
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

