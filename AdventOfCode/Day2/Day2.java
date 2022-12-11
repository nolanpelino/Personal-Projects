import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Day2 {
    public final Map<String, Integer> scores = Map.of("A X", 4, "A Y", 8, "A Z", 3, "B X", 1, "B Y", 5,
            "B Z", 9, "C X", 7, "C Y", 2, "C Z", 6);  // Map based on part 1 rules

    public final Map<String, Integer> scoresCorrect = Map.of("A X", 3, "A Y", 4, "A Z", 8, "B X", 1, "B Y", 5,
    "B Z", 9, "C X", 2, "C Y", 6, "C Z", 7);  // Map based on part 2 rules
            
    public static void main(String[] args) {
        Day2 day2 = new Day2();
        day2.readFile();
        day2.readFileCorrect();
    }
    
    public Day2() {
        // do nothing
    }
    /*
     * Reads the inputed file, and compares the strings to the hardcoded map. If the
     * string is found in the map, it adds the value to the total.
     */
    public void readFile() {
        Integer total = 0;

        try (Scanner scan = new Scanner(new File("/home/nolanpelino/Personal-Projects/AdventOfCode/Day2/input.txt"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine(); 
                total = total + scores.get(line);
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void readFileCorrect() {
        Integer total = 0;
        try (Scanner scan = new Scanner(new File("/home/nolanpelino/Personal-Projects/AdventOfCode/Day2/input.txt"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine(); 
                total = total + scoresCorrect.get(line);
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}