// Author: Nolan Pelino
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1 {
    String file;

    public day1(String input){
        this.file = input;  // Object takes in the requested input file
    }

    public static void main(String[] args) {
        day1 answer = new day1("Personal-Projects/AdventOfCode/Day1/input.txt");
        answer.readCalorieCounts();  // Read the input file and calculate the answer. Prints answer to console
    }

    public void readCalorieCounts() {
        ArrayList<Integer> calorieCounts = new ArrayList<Integer>();
        Integer group = 0;  // Current gorup's calorie count
        Integer firstGroup = 0;
        Integer secondGroup = 0;
        Integer thirdGroup = 0;
        try (Scanner scan = new Scanner(new File(this.file))) {
            while (scan.hasNextLine()) {  // While the file is not finished
                String line = scan.nextLine().trim();
                if (!line.isEmpty()) {  // If the line is not empty
                    group = group + Integer.parseInt(line);
                } else {  // If the line is empty, add the current group's calorie count to the list
                    calorieCounts.add(group);
                    if (group > firstGroup) {  // If the largest
                        thirdGroup = secondGroup;
                        secondGroup = firstGroup;
                        firstGroup = group;
                    } else if (group >= secondGroup && group < firstGroup) {  // If the second largest
                        thirdGroup = secondGroup;
                        secondGroup = group;
                    } else if (group >= thirdGroup && group < secondGroup) {  // If the third largest
                        thirdGroup = group;
                    }
                    group = 0;  // Reset group count
                }
            }
            System.out.println(firstGroup + secondGroup + thirdGroup);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}