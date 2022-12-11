// Author: Nolan Pelino
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day1 {
    String file;

    public day1(String input){
        this.file = input;
    }

    public static void main(String[] args) {
        day1 answer = new day1("Personal-Projects/AdventOfCode/Day1/input.txt");
        answer.readCalorieCounts();
    }

    public void readCalorieCounts() {
        ArrayList<Integer> calorieCounts = new ArrayList<Integer>();
        Integer group = 0;
        Integer firstGroup = 0;
        Integer secondGroup = 0;
        Integer thirdGroup = 0;
        try (Scanner scan = new Scanner(new File(this.file))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (!line.isEmpty()) {
                    group = group + Integer.parseInt(line);
                } else {
                    calorieCounts.add(group);
                    if (group > firstGroup) {
                        thirdGroup = secondGroup;
                        secondGroup = firstGroup;
                        firstGroup = group;
                    } else if (group >= secondGroup && group < firstGroup) {
                        thirdGroup = secondGroup;
                        secondGroup = group;
                    } else if (group >= thirdGroup && group < secondGroup) {
                        thirdGroup = group;
                    }
                    group = 0;
                }
            }
            System.out.println(firstGroup + secondGroup + thirdGroup);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}